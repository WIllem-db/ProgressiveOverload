package dtos;

import domain.Workout;

public record WorkoutDTO(String name) {
    public static WorkoutDTO createWorkoutDTO(Workout workout) {
        return new WorkoutDTO(workout.getName());
    }
}
