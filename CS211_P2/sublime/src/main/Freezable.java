/*
* Name: Aniketh Voduru
* netID: avoduru
* G#: 01423733
* Lecture section: 001
* Lab section: 202
*/
package src.main;

public interface Freezable {
    /*
     * The Freezable interface is designed to provide a standardized specification
     * for objects that require the functionality
     * to temporarily suspend their operations. This interface mandates the
     * implementation of a specific behavior to "freeze"
     * ongoing processes, ensuring the safe cessation of activities.
     */

    // The implementing classes provides behavior according to the interface
    // specification.
    boolean freeze();
}
