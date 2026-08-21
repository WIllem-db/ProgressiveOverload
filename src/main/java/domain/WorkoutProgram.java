package domain;


import java.util.List;

public class WorkoutProgram {
    private String name;
    private List<Workout> workouts;
    /// {@code fullRotation} represents one full training block containing all workouts and rest days in consecutive order.
    private List<Workout> fullRoutine; // We can use null for representing a rest day (more elegant solution likely exists)

    public WorkoutProgram(String name) {
        this.name = name;
    }

    public void initializeFullRoutine(List<Workout> fullRotation) {
        this.fullRoutine = fullRotation;
    }

    public String getName() {
        return name;
    }

    public List<Workout> getFullRoutine() {
        return fullRoutine;
    }
}
