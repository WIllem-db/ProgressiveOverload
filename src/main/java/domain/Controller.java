package domain;

import dtos.ExerciseDTO;
import dtos.WorkoutDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    private Workout selectedWorkout;
    private Exercise selectedExercise;
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
        Exercise exercise = new Exercise(name, amountOfSets, restTimeInSeconds);
        selectedWorkout.addExercise(exercise);
        exerciseRepository.addExerciseToList(exercise);
    }

    public void addNotesToExercise(String notes) {
        selectedExercise.setNotes(notes);
    }

    public void addFixedRepsToExerciseSet(int setNumber, int reps) {
        addSetToExercise(setNumber, new RepTarget.Fixed(reps));
    }

    public void addRepRangeExerciseSet(int setNumber, int min, int max) {
        addSetToExercise(setNumber, new RepTarget.Range(min, max));
    }

    public void addRestPauseRepsToExerciseSet(int setNumber, List<Integer> reps) {
        addSetToExercise(setNumber, new RepTarget.RestPause(reps));
    }

    public void switchExercise(String nameCurrentExercise, String nameNewExercise, int amountOfSets, int restTimeInSeconds) {
        selectedWorkout.switchExercise(nameCurrentExercise, nameNewExercise, amountOfSets, restTimeInSeconds);
    }

    public void switchExerciseName(String currentName, String newName) {
        selectedWorkout.switchExerciseName(currentName, newName);
    }

    public void createWorkoutProgram(String name) {
        workoutProgram = new WorkoutProgram(name);
        workoutProgram.initializeFullRoutine((List<Workout>) workoutRepository.giveAllWorkouts());
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

    public String giveFullWorkoutProgram() {
        return buildWorkoutProgramString();
    }

    // Return DTO objects

    public Collection<WorkoutDTO> giveAllWorkouts() {
        return createWorkoutDTOs(workoutRepository.giveAllWorkouts());
    }

    public Collection<ExerciseDTO> giveAllExercises() {
        return createExerciseDTOs(exerciseRepository.giveAllExercises());
    }

    // Select specific object methods

    public void selectWorkout(String name) {
        selectedWorkout = getWorkoutByName(name);
    }

    public void selectExercise(String name) {
        selectedExercise = getExerciseByName(name);
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

    private String buildWorkoutProgramString() {
        // workout
        // Exercise + sets + reptarget(s) + restTime + notes
        List<Workout> workouts = workoutProgram.getFullRoutine();
        String workoutProgramString = "";
        for (Workout workout : workouts) {
            workoutProgramString += String.format("%s%n", workout.getName());
            for (Exercise exercise : workout.getExercises()) {
                workoutProgramString += String.format(
                        "%s  %d  ",
                        exercise.getName(),
                        exercise.getAmountOfSets()
                );
                List<String> repTargets = new ArrayList<>();
                for (ExerciseSet set : exercise.getSets()) {
                    RepTarget repTarget = set.getRepTarget();
                    if (repTarget instanceof RepTarget.Fixed fixed) {
                        repTargets.add(String.valueOf(fixed.reps()));
                    } else if (repTarget instanceof RepTarget.Range range) {
                        repTargets.add(String.format("%d-%d", range.min(), range.max()));
                    } else if (repTarget instanceof RepTarget.RestPause restPause) {
                        repTargets.add(restPause.reps()
                                .stream()
                                .map(Object::toString)
                                .collect(Collectors.joining(", ")));
                    }
                }
                workoutProgramString += String.format("%s  %s%n", repTargets, exercise.getNotes() != null ? exercise.getNotes() : "");
            }
        }
        return workoutProgramString;
    }

    private void addSetToExercise(int setNumber, RepTarget repTarget) {
        selectedExercise.addSet(setNumber, repTarget);
    }
}
