package src.main;
import java.util.*;

public record MemorySnapshot(ArrayList<SystemWhole>emulationMemory,ArrayList<SystemWhole>simulacraMemory,ArrayList<SystemWhole>simulationMemory){}