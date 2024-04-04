package src.main;

public class Host extends Dolores implements Freezable {
    /*
     * narrativeLoop: this field is a private instance of the NarrativeLoop type.
     * It's initialized in the constructor.
     */
    private NarrativeLoop narrativeLoop;

    public Host(NarrativeLoop narrativeLoop) {
        /*
         * Make sure this public method calls its the Dolores superclass's constructor.
         * The narrativeLoop argument is directly assigned to the Host class's private
         * final NarrativeLoop narrativeLoop field.
         * This field holds a reference to the NarrativeLoop instance associated with
         * this Host.
         */
        this.narrativeLoop = narrativeLoop;
        super.addNarrativeLoop(this.narrativeLoop);
    }

    public boolean freezeAllMotorFunctions() {
        /*
         * Mimics a command to halt all of the host's operations and activities.
         * The method consistently returns true, indicating that the freeze command was
         * successful every time it's called.
         */
        return true;
    }

    @Override
    public MemorySnapshot analyze() {
        /*
         * Begins by checking if the narrativeLoop field is null. If it is, the method
         * returns null,
         * indicating there's no narrative loop to analyze.
         */
        if (narrativeLoop == null) {
            return null;
        }
        /*
         * If narrativeLoop is not null, the method creates and returns a new
         * MemorySnapshot instance.
         */
        else {
            /*
             * This snapshot is constructed using the emulation, simulacra, and simulation
             * lists from the narrativeLoop field.
             */
            MemorySnapshot memorySnapshot = new MemorySnapshot(narrativeLoop.emulation, narrativeLoop.simulacra,
                    narrativeLoop.simulation);
            return memorySnapshot;
        }

    }

    @Override
    public void wipe() {
        /*
         * Calls the wipeNarrativeLoops() method of the narrativeLoop field.
         * This action is meant to reset or clear the narrative states within the loop,
         * aligning with the intended functionality of a wipe operation in a narrative
         * management context.
         */
        narrativeLoop.wipeNarrativeLoops();
    }

    @Override
    public boolean freeze() {
        /*
         * Implements the freeze method from the Freezable interface by invoking
         * freezeAllMotorFunctions().
         * This ensures that the freeze behavior defined specifically in the Host class
         * is used for the Freezable interface's freeze operation.
         * The return value of freezeAllMotorFunctions() (which is always true) is also
         * the return value of this freeze method,
         * indicating the success of the freeze operation.
         */
        return freezeAllMotorFunctions();
    }

}
