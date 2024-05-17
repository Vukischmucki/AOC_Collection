package aoc_2015.Day6Light;

public enum LightOperation {
    TURN_ON {
        public int apply(int brightness) {
            return brightness + 1;
        }
    },

    TURN_OFF {
        public int apply(int brightness) {
            return Math.max(0, brightness - 1);
        }
    },

    TOGGLE {
        public int apply(int brightness) {
            return brightness + 2;
        }
    };

    public abstract int apply(int brightness);
}