package src.main;

public interface Wipeable extends Analyzable {
    /*
     * The Wipeable interface extends the Analyzable interface, introducing
     * specifications for objects that not only require
     * analytical capabilities but also the ability to reset or clear their state.
     * This extension ensures that objects adhering
     * to this interface can both be analyzed and have their data or operations
     * "wiped" to a clean state.
     */

    /*
     * In alignment with the interface specification, implementing classes are
     * tasked with defining a behavior for the wipe method.
     * This method, when invoked, should clear or reset the state of the object.
     */
    void wipe();
}
