package dtos;

import domain.ExerciseSet;
import domain.RepTarget;

public record ExerciseSetDTO(int setNumber, RepTarget repTarget) {
    public static ExerciseSetDTO createExerciseSetDTO(ExerciseSet exerciseSet) {
        return new ExerciseSetDTO(exerciseSet.getSetNumber(), exerciseSet.getRepTarget());
    }
}
