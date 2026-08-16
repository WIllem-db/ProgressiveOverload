package domain;

import persistence.ExerciseMapper;

import java.util.Collection;
import java.util.Optional;

public class ExerciseRepository {
    private final ExerciseMapper mapper;

    public ExerciseRepository() {
        mapper = new ExerciseMapper();
    }

    public Collection<Exercise> giveAllExercises() {
        return mapper.giveExercises();
    }

    public void addExerciseToList(Exercise exercise) {
        mapper.addExercise(exercise);
    }

    public Optional<Exercise> giveExerciseByName(String name) {
        return giveAllExercises().stream()
                .filter(exercise -> exercise.getName().equalsIgnoreCase(name))
                .findAny();
    }
}
