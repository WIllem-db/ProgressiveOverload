package domain;


import java.util.List;

public class WorkoutProgram {
    private String name;
    private List<Workout> workouts;
    /// @param fullRotation represents one full training block containing all workouts and rest days in consecutive order.
    private List<Workout> fullRotation; // We can use null for representing a rest day (more elegant solution likely exists)

    public WorkoutProgram(String name) {
        this.name = name;
    }

    public void setFullRotation(List<Workout> fullRotation) {
        this.fullRotation = fullRotation;
    }

    public List<Workout> getFullRotation() {
        return fullRotation;
    }
}
