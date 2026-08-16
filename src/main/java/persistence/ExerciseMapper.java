package persistence;

import domain.Exercise;

import java.util.ArrayList;
import java.util.List;

public class ExerciseMapper {
    private List<Exercise> exercises;

    public ExerciseMapper() {
        exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
    }

    public List<Exercise> giveExercises() {
        return exercises;
    }
}
