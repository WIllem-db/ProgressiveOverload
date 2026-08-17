package domain;

import dtos.ExerciseDTO;
import dtos.WorkoutDTO;
import dtos.WorkoutProgramDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Controller {
    private Workout workout;
    private Exercise exercise;
    /// {@code workoutProgram} represents the full routine of all workouts + rest days
    private WorkoutProgram workoutProgram;
    private WorkoutRepository workoutRepository;
    private ExerciseRepository exerciseRepository;

    public Controller() {
        workoutRepository = new WorkoutRepository();
        exerciseRepository = new ExerciseRepository();
    }

    public void createNewWorkout(String name) {
        workoutRepository.addWorkoutToList(new Workout(name));
    }

    public void addExercise(String name, int amountOfSets, int restTimeInSeconds) {
        workout.addExercise(name, amountOfSets, restTimeInSeconds);
    }

    public void addSetToExercise(int setNumber, int reps, RepTarget repTarget) {
        exercise.addSet(setNumber, reps, repTarget);
    }

    public void switchExercise(String nameCurrentExercise, String nameNewExercise, int amountOfSets, int restTimeInSeconds) {
        workout.switchExercise(nameCurrentExercise, nameNewExercise, amountOfSets, restTimeInSeconds);
    }

    public void switchExerciseName(String currentName, String newName) {
        workout.switchExerciseName(currentName, newName);
    }

    public void createWorkoutProgram(String name) {
        workoutProgram = new WorkoutProgram(name);
    }

    public void setFullRotation(List<String> workoutNames) {
        List<Workout> workouts = new ArrayList<>();
        for (String workoutName : workoutNames) {
            if (workoutName.equalsIgnoreCase("rest")) {
                workouts.add(null);
            }
            workouts.add(getWorkoutByName(workoutName));
        }
        workoutProgram.initializeFullRoutine(workouts);
    }

    // Return DTO objects

    public Collection<WorkoutDTO> giveAllWorkouts() {
        return createWorkoutDTOs(workoutRepository.giveAllWorkouts());
    }

    public Collection<ExerciseDTO> giveAllExercises() {
        return createExerciseDTOs(exerciseRepository.giveAllExercises());
    }

    // Select specific object methods

    private void selectWorkout(String name) {
        workout = getWorkoutByName(name);
    }

    private void selectExercise(String name) {
        exercise = getExerciseByName(name);
    }

    // Private helper methods

    private Workout getWorkoutByName(String name) {
        return workoutRepository.giveWorkoutByName(name)
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("Workout %s does not exist!", name)
                ));
    }

    private Exercise getExerciseByName(String name) {
        return exerciseRepository.giveExerciseByName(name)
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("Exercise %s does not exist!", name)
                ));
    }

    private Collection<WorkoutDTO> createWorkoutDTOs(Collection<Workout> workouts) {
        Collection<WorkoutDTO> workoutDTOs = new ArrayList<>();
        for (Workout workout1 : workouts) {
            workoutDTOs.add(WorkoutDTO.createWorkoutDTO(workout1));
        }
        return workoutDTOs;
    }

    private Collection<ExerciseDTO> createExerciseDTOs(Collection<Exercise> exercises) {
        Collection<ExerciseDTO> exerciseDTOs = new ArrayList<>();
        for (Exercise exercise1 : exercises) {
            exerciseDTOs.add(ExerciseDTO.createExerciseDTO(exercise1));
        }
        return exerciseDTOs;
    }

    private Collection<WorkoutProgramDTO> createWorkoutProgramDTO(Collection<WorkoutProgram> workoutPrograms) {
        Collection<WorkoutProgramDTO> workoutProgramDTOs = new ArrayList<>();
        for (WorkoutProgram program : workoutPrograms) {
            workoutProgramDTOs.add(WorkoutProgramDTO.createWorkoutProgramDTO(program));
        }
        return workoutProgramDTOs;
    }
}
