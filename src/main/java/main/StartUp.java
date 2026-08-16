package main;

import domain.Controller;
import cui.WorkoutApplicatie;

public class StartUp {
    public static void main(String[] args) {
        new WorkoutApplicatie(new Controller()).start();
    }
}
