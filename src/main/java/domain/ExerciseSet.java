package domain;

public class ExerciseSet {
    private int setNumber;
    private RepTarget repTarget;

    public ExerciseSet(int setNumber, RepTarget repTarget) {
        this.setNumber = setNumber;
        this.repTarget = repTarget;
    }

    public int getSetNumber() {
        return setNumber;
    }

    public RepTarget getRepTarget() {
        return repTarget;
    }
}
