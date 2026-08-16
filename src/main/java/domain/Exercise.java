package domain;

import java.util.ArrayList;
import java.util.List;

public class Exercise {
    private String name;
    private int amountOfSets;
    private int restTimeInSeconds;
    private List<ExerciseSet> sets;

    public Exercise(String name, int amountOfSets, int restTimeInSeconds) {
        this.name = name;
        this.amountOfSets = amountOfSets;
        this.restTimeInSeconds = restTimeInSeconds;
        this.sets = new ArrayList<>();
    }

    public void setRestTimeInSeconds(int restTimeInSeconds) {
        this.restTimeInSeconds = restTimeInSeconds;
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

    public List<ExerciseSet> getSets() {
        return sets;
    }

    public void addSet(int setNumber, int reps, RepTarget repTarget) {
        sets.add(new ExerciseSet(setNumber, reps, repTarget));
    }
}
