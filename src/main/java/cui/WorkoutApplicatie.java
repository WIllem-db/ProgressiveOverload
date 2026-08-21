package cui;

import domain.Controller;
import java.util.Scanner;

public class WorkoutApplicatie {
    private final Controller controller;
    private final Scanner scanner;

    public WorkoutApplicatie(Controller controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void start() {
        createFullProgram();
        showFullProgram();
    }

    private void createFullProgram() {
        controller.createNewWorkout("Push 1");
        controller.selectWorkout("Push 1");
        // Exercise 1
        controller.addExercise("High incline machine press", 2, 180);
        controller.selectExercise("High incline machine press");
        controller.addRepRangeExerciseSet(1, 5, 9);
        controller.addRepRangeExerciseSet(2, 10, 12);
        // Exercise 2
        controller.addExercise("Flat DB press", 2, 180);
        controller.selectExercise("Flat DB press");
        controller.addRepRangeExerciseSet(1, 5, 9);
        controller.addRepRangeExerciseSet(2, 10, 12);

        controller.addExercise("Abs", 4, 60);
        controller.selectExercise("Abs");
        controller.addNotesToExercise("Choose any ab exercise");
        for (int i = 0; i < 4; i++) {
            controller.addFixedRepsToExerciseSet(i, 15);
        }

        controller.createWorkoutProgram("PPL");
    }

    private void showFullProgram() {
        System.out.print(controller.giveFullWorkoutProgram());
    }
}
