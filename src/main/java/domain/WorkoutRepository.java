package domain;

import persistence.WorkoutMapper;

import java.util.Collection;
import java.util.Optional;

public class WorkoutRepository {
    private final WorkoutMapper mapper;

    public WorkoutRepository() {
        mapper = new WorkoutMapper();
    }

    public Collection<Workout> giveAllWorkouts() {
        return mapper.giveWorkouts();
    }

    public void addWorkoutToList(Workout workout) {
        mapper.addWorkout(workout);
    }

    public Optional<Workout> giveWorkoutByName(String name) {
        return giveAllWorkouts().stream()
                .filter(workout -> workout.getName().equalsIgnoreCase(name))
                .findAny();
    }
}
