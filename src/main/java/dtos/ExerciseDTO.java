package dtos;

import domain.Exercise;

public record ExerciseDTO(String name, int amountOfSets, int restTimeInSeconds, boolean isPrimaryExercise) {
    public static ExerciseDTO createExerciseDTO(Exercise exercise) {
        return new ExerciseDTO(exercise.getName(), exercise.getAmountOfSets(), exercise.getRestTimeInSeconds(), exercise.isPrimaryExercise());
    }
}
