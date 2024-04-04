package src.main;

public interface Analyzable {
    /*
     * The Analyzable interface is crafted to establish a uniform specification for
     * objects that necessitate the capability to be analyzed,
     * yielding insights or data snapshots of their current state. This interface
     * obligates the concrete implementation of an analysis routine
     * that scrutinizes the object's state or behavior.
     */

    /*
     * The method to be implemented as per the interface specification mandates that
     * implementing classes provide a
     * behavior that analyzes the current state or condition of the object and
     * returns a MemorySnapshot.
     */
    MemorySnapshot analyze();
}
