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
        Exercise exercise = findExerciseByName(nameCurrentExercise);
        int index = exercises.indexOf(exercise);
        exercises.remove(exercise);
        exercises.add(index, new Exercise(nameNewExercise, amountOfSets, restTimeInSeconds));
    }

    public void switchExerciseName(String currentName, String newName) {
        Exercise exercise = findExerciseByName(currentName);
        exercise.setName(newName);
    }

    private Exercise findExerciseByName(String name) {
        return exercises.stream()
                .filter(e -> e.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("%s does not exist!", name)
                ));
    }

    public String getName() {
        return name;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

}
