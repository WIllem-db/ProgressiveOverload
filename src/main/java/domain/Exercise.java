package domain;

import java.util.ArrayList;
import java.util.List;

public class Exercise {
    private String name;
    private int amountOfSets;
    private int restTimeInSeconds;
    private List<ExerciseSet> sets;
    private boolean isPrimaryExercise;
    private String notes;

    public Exercise(String name, int amountOfSets, int restTimeInSeconds) {
        this.name = name;
        this.amountOfSets = amountOfSets;
        this.restTimeInSeconds = restTimeInSeconds;
        this.sets = new ArrayList<>();
        isPrimaryExercise = false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRestTimeInSeconds(int restTimeInSeconds) {
        this.restTimeInSeconds = restTimeInSeconds;
    }

    public void setExerciseAsPrimaryExercise() {
        isPrimaryExercise = true;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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

    public String getNotes() {
        return notes;
    }

    public void addSet(int setNumber, RepTarget repTarget) {
        sets.add(new ExerciseSet(setNumber, repTarget));
    }
}
