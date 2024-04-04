package src.main;

import java.util.*;

abstract class NarrativeLoop {
    /*
     * The NarrativeLoop class includes three fields, all final and protected,
     * List of SystemWholes initialized to new ArrayLists
     */
    protected final ArrayList<SystemWhole> emulation = new ArrayList<SystemWhole>();
    protected final ArrayList<SystemWhole> simulacra = new ArrayList<SystemWhole>();
    protected final ArrayList<SystemWhole> simulation = new ArrayList<SystemWhole>();

    public void wipeNarrativeLoops() {
        /*
         * This public method clear the lists. The method resets the narrative
         * environment by clearing the emulation, simulacra, and simulation
         * lists, removing all SystemWhole instances from each realm.
         */
        emulation.clear();
        simulacra.clear();
        simulation.clear();
    }

    public final void updateNarrativeLoops(SystemWhole[] emulationContext, SystemWhole[] simulacraContext) {
        // Begin by iterating over each SystemWhole in the emulationContext array.
        for (SystemWhole sys : emulationContext) {
            // For each SystemWhole, iterate through the Machines it contains.
            for (Machine mach : sys.reify()) {
                // Invoke determineRealm with the Machine's kind and both context arrays as
                // parameters.
                Realm realm = determineRealm(mach.getKind(), emulationContext, simulacraContext);
                /*
                 * If determineRealm returns Realm.EMULATION and containsKind confirms the
                 * emulation list doesn't already include a Machine of this kind or the same
                 * SystemWhole reference, add the SystemWhole
                 * to emulation.
                 */
                if (realm == Realm.EMULATION && !(containsKind(emulation, mach.getKind()))) {
                    emulation.add(sys);
                }
            }

        }
        /*
         * Repeat the process for the simulacraContext array. Including checking for the
         * SystemWhole reference already in the list,
         * or any of its Machines kinds.
         */
        for (SystemWhole system : simulacraContext) {
            for (Machine machine : system.reify()) {
                Realm realm = determineRealm(machine.getKind(), emulationContext, simulacraContext);
                // For Realm.SIMULACRA, add SystemWholes to simulacra.
                if (realm == Realm.SIMULACRA && !(containsKind(emulation, machine.getKind()))) {
                    simulacra.add(system);
                }
                // For Realm.SIMULATION, add SystemWholes to simulation.
                if (realm == Realm.SIMULATION && !(containsKind(emulation, machine.getKind()))) {
                    simulation.add(system);
                }
            }
        }

    }

    private final Realm determineRealm(String kind, SystemWhole[] emulationContext, SystemWhole[] simulacraContext) {
        // Check for the presence of the Machine kind in both emulationContext and
        // simulacraContext using isInContext.
        boolean emulationKind = isInContext(kind, emulationContext);
        boolean simulacraKind = isInContext(kind, simulacraContext);
        // Assign Realm.SIMULATION if the kind is found in both contexts.
        if (emulationKind && simulacraKind) {
            return Realm.SIMULATION;
        }
        // Assign Realm.SIMULACRA if the kind is found only in simulacraContext.
        else if (simulacraKind) {
            return Realm.SIMULACRA;
        }
        // Default to Realm.EMULATION if neither of the above conditions is met.
        else {
            return Realm.EMULATION;
        }
    }

    private final boolean isInContext(String kind, SystemWhole[] context) {
        // Iterate through the SystemWhole array provided as context.
        for (SystemWhole sys : context) {
            // Within each SystemWhole, iterate through its Machines.
            for (Machine mach : sys.reify()) {
                // Return true if any Machine matches the specified kind.
                if (kind.equals(mach.getKind())) {
                    return true;
                }
            }
        }
        // Return false if no match is found.
        return false;

    }

    private final boolean containsKind(List<SystemWhole> list, String kind) {
        // Iterate over the provided list of SystemWhole instances.
        for (SystemWhole system : list) {
            // For each SystemWhole, iterate through its Machines.
            for (Machine machine : system.reify()) {
                // Return true if any Machine within the SystemWhole matches the specified kind.
                if (machine.getKind().equals(kind)) {
                    return true;
                }
            }
        }
        // Return false if no matching Machine kind is found within any SystemWhole in
        // the list.
        return false;
    }
}
