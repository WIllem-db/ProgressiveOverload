package domain;

import java.util.ArrayList;
import java.util.List;

public class Exercise {
    private String name;
    private int amountOfSets;
    private int restTimeInSeconds;
    private List<ExerciseSet> sets;
    private boolean isPrimaryExercise;

    public Exercise(String name, int amountOfSets, int restTimeInSeconds) {
        this.name = name;
        this.amountOfSets = amountOfSets;
        this.restTimeInSeconds = restTimeInSeconds;
        this.sets = new ArrayList<>();
        isPrimaryExercise = false;
    }

    public void setRestTimeInSeconds(int restTimeInSeconds) {
        this.restTimeInSeconds = restTimeInSeconds;
    }

    public void setExerciseAsPrimaryExercise() {
        isPrimaryExercise = true;
    }

    public String getName() {
        return name;
    }

    public int getAmountOfSets() {
        return amountOfSets;
    }

    public int getRestTimeInSeconds() {
        return restTimeInSeconds;
    }

    public boolean isPrimaryExercise() {
        return isPrimaryExercise;
    }

    public List<ExerciseSet> getSets() {
        return sets;
    }

    public void addSet(int setNumber, int reps, RepTarget repTarget) {
        sets.add(new ExerciseSet(setNumber, reps, repTarget));
    }

    public List<RepTarget> getRepTargetsForEverySet() {
        List<RepTarget> repTargets = new ArrayList<>();
        for (ExerciseSet set : sets) {
            repTargets.add(set.getRepTarget());
        }
        return repTargets;
    }
}
