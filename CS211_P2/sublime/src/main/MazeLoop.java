package src.main;

public class MazeLoop extends NarrativeLoop {
    @Override
    public void wipeNarrativeLoops() {
        // It overrides the wipeNarrativeLoops() method to implement maze-specific
        // narrative wiping logic,
        // which is just not allow the inherited wipe behavior.
    }
}
