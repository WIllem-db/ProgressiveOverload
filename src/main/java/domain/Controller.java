package domain;

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

    // TODO: Do we need to implement DTO for all data returned back to the CUI/UI layer?
    public List<RepTarget> giveAllSetsForExercise() {
        return exercise.getRepTargetsForEverySet();
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
}
