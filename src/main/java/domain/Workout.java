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

    public void switchExercise(String nameCurrentExercise, String nameNewExercise, int amountOfSets, int restTimeInSeconds) {
        // TODO: can we avoid stream and just use list iterator?
        Exercise exercise = exercises.stream()
                .filter(e -> e.getName().equalsIgnoreCase(nameCurrentExercise))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("%s does not exist!", nameCurrentExercise)
                ));
        int index = exercises.indexOf(exercise);
        exercises.remove(exercise);
        exercises.add(index, new Exercise(nameNewExercise, amountOfSets, restTimeInSeconds));
    }

    public String getName() {
        return name;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }
}
