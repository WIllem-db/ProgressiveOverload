package persistence;

import domain.Workout;

import java.util.ArrayList;
import java.util.List;

public class WorkoutMapper {
    private List<Workout> workouts;

    public WorkoutMapper() {
        workouts = new ArrayList<>();
    }

    public void addWorkout(Workout workout) {
        workouts.add(workout);
    }

    public List<Workout> giveWorkouts() {
        return workouts;
    }
}
