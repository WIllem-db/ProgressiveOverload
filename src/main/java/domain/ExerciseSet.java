package domain;

public class ExerciseSet {
    private int setNumber;
    private RepTarget repTarget;
    private String notes;

    public ExerciseSet(int setNumber, RepTarget repTarget) {
        this.setNumber = setNumber;
        this.repTarget = repTarget;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getSetNumber() {
        return setNumber;
    }

    public RepTarget getRepTarget() {
        return repTarget;
    }

    public String getNotes() {
        return notes;
    }
}
