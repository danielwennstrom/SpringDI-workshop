package org.example.sequencer;

public class StudentSequencer {
    private static int idCounter = 1;
    
    public static int getNextId() {
        return idCounter++;
    }
}
