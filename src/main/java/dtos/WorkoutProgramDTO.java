package dtos;

import domain.*;

import java.util.ArrayList;
import java.util.List;

public record WorkoutProgramDTO(String name, List<WorkoutDTO> fullRoutine, List<ExerciseDTO> exercises, List<ExerciseSetDTO> exerciseSets, List<RepTargetDTO> repTarget) {
    public static WorkoutProgramDTO createFullWorkoutProgramDTO(WorkoutProgram workoutProgram) {
        List<WorkoutDTO> workoutDTOs = convertWorkoutProgramtoDTOs(workoutProgram);
        List<Workout> workouts = workoutProgram.getFullRoutine();
        List<ExerciseDTO> exerciseDTOs = new ArrayList<>();
        List<ExerciseSetDTO> exerciseSetDTOs = new ArrayList<>();
        List<RepTargetDTO> repTargetDTOs = new ArrayList<>();
        for (Workout workout : workouts) {
            List<Exercise> exercises = workout.getExercises();
            for (Exercise exercise : exercises) {
                exerciseDTOs.add(ExerciseDTO.createExerciseDTO(exercise));
                for (ExerciseSet set : exercise.getSets()) {
                    exerciseSetDTOs.add(ExerciseSetDTO.createExerciseSetDTO(set));
                    repTargetDTOs.add(convertRepTargetToDTO(set.getRepTarget()));
                }
            }
        }
        return new WorkoutProgramDTO(workoutProgram.getName(), workoutDTOs, exerciseDTOs, exerciseSetDTOs, repTargetDTOs);
    }

    public static RepTargetDTO convertRepTargetToDTO(RepTarget repTarget) {
        return switch (repTarget) {
            case RepTarget.Fixed f     -> new RepTargetDTO.Fixed(f.reps());
            case RepTarget.Range r     -> new RepTargetDTO.Range(r.min(), r.max());
            case RepTarget.RestPause p -> new RepTargetDTO.RestPause(p.reps());
        };
    }

    private static List<WorkoutDTO> convertWorkoutProgramtoDTOs(WorkoutProgram workoutProgram) {
        List<WorkoutDTO> workoutDTOs = new ArrayList<>();
        for (Workout workout : workoutProgram.getFullRoutine()) {
            if (workout != null) {
                workoutDTOs.add(WorkoutDTO.createWorkoutDTO(workout));
            }
            workoutDTOs.add(WorkoutDTO.createRestDayForWorkoutDTO());
        }
        return workoutDTOs;
    }
}
