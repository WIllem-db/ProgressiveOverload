package domain;

import java.util.ArrayList;
import java.util.List;

public class Workout {
    private String name;
    private List<Exercise> exercises;

    public Workout(String name) {
        this.name = name;
        exercises = new ArrayList<>();
    }

    public void addExercise(String name, int amountOfSets, int restTimeInSeconds) {
        exercises.add(new Exercise(name, amountOfSets, restTimeInSeconds));
    }

    public String getName() {
        return name;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }
}
