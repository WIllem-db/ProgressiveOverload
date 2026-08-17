package dtos;

import java.util.List;

public sealed interface RepTargetDTO {
    record Fixed(int reps) implements RepTargetDTO {}
    record Range(int min, int max) implements RepTargetDTO {}
    record RestPause(List<Integer> reps) implements RepTargetDTO {
        public RestPause { reps = List.copyOf(reps); }
    }
}
