package domain;

import java.util.List;

public sealed interface RepTarget {
    record Fixed(int reps) implements RepTarget {
        public Fixed {
            if (reps < 1) {
                throw new IllegalArgumentException("Rep target must be greater than 0!");
            }

        }
    }

    record Range(int min, int max) implements RepTarget {
        public Range {
            if (min < 1) {
                throw new IllegalArgumentException("Min rep target must be greater than 0!");
            } else if (max <= min) {
                throw new IllegalArgumentException("Max rep target must be greater than min rep target!");
            }
        }
    }

    record RestPause(List<Integer> reps) implements RepTarget {
        public RestPause {
            for (Integer rep : reps) {
                if (!String.valueOf(rep).matches("\\d")) {
                    throw new IllegalArgumentException("Reps must all be of type int!");
                } else if (rep < 1) {
                    throw new IllegalArgumentException("All rep targets must be greater than 0!");
                }
            }
        }
    }
}
