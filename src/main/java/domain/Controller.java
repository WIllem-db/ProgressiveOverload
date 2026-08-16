package domain;

import dtos.ExerciseDTO;
import dtos.WorkoutDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Controller {
    private Workout workout;
    private Exercise exercise;
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

    // Return DTO objects

    public Collection<WorkoutDTO> giveAllWorkouts() {
        return createWorkoutDTOs(workoutRepository.giveAllWorkouts());
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
            exercises.add(ExerciseDTO.createExerciseDTO(exercise1));
        }
    }
}
