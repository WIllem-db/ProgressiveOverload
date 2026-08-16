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
        addWorkout();
    }

    private void addWorkout() {
        boolean stop = false;
        while (!stop) {
            System.out.print("Workout name: ");
            String name = scanner.nextLine();
            controller.createNewWorkout(name);
            addExercise();
        }
    }

    private void addExercise() {
        boolean stop = false;
        while (!stop) {
            System.out.print("Exercise name: ");
            String name = scanner.nextLine();
            System.out.print("Amount of sets: ");
            int amountOfSets = Integer.parseInt(scanner.nextLine());
            System.out.print("Rest time in seconds (enter 0 if irrelevant): ");
            int restTimeInSeconds = Integer.parseInt(scanner.nextLine());
            controller.addExercise(name, amountOfSets, restTimeInSeconds);
            System.out.print("1. Continue\n2.Stop\nEnter: ");
            int answer = Integer.parseInt(scanner.nextLine());
            stop = answer != 1;
        }
    }
}
