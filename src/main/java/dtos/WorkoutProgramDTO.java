package dtos;

import domain.Workout;
import domain.WorkoutProgram;

import java.util.List;

public record WorkoutProgramDTO(String name, List<Workout> fullRotation) {
    public static WorkoutProgramDTO createWorkoutProgramDTO(WorkoutProgram workoutProgram) {
        return new WorkoutProgramDTO(workoutProgram.getName(), workoutProgram.getFullRoutine());
    }
}
