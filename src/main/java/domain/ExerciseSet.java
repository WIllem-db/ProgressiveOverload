package domain;

public class ExerciseSet {
    private int setNumber;
    private int reps;
    private RepTarget repTarget;
    private String notes;

    public ExerciseSet(int setNumber, int reps, RepTarget repTarget) {
        this.setNumber = setNumber;
        this.reps = reps;
        this.repTarget = repTarget;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getSetNumber() {
        return setNumber;
    }

    public int getReps() {
        return reps;
    }

    public String getNotes() {
        return notes;
    }
}
