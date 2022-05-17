package id.ac.ui.cs.advancedprogramming.controlwand.core.entity.magictool;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.MagicalEntityState;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum ManaIntensity implements MagicalEntityState {
    NONE {
        @Override
        public boolean off(MagicTool magicTool) {
            return false;
        }

        @Override
        public String getName() {
            return "NONE";
        }
    }, LOW {
        @Override
        public boolean low(MagicTool magicTool) {
            return false;
        }

        @Override
        public String getName() {
            return "LOW";
        }
    }, MEDIUM {
        @Override
        public boolean medium(MagicTool magicTool) {
            return false;
        }

        @Override
        public String getName() {
            return "MEDIUM";
        }
    }, HIGH {
        @Override
        public boolean high(MagicTool magicTool) {
            return false;
        }

        @Override
        public String getName() {
            return "HIGH";
        }
    };

    public static List<ManaIntensity> getNonNullManaIntensities() {
        return Arrays.stream(ManaIntensity.values())
                .filter(v -> v != ManaIntensity.NONE)
                .collect(Collectors.toList());
    }

    public boolean off(MagicTool magicTool) {
        magicTool.setCurrentState(NONE);
        return true;
    }

    public boolean low(MagicTool magicTool) {
        magicTool.setCurrentState(LOW);
        return true;
    }

    public boolean medium(MagicTool magicTool) {
        magicTool.setCurrentState(MEDIUM);
        return true;
    }

    public boolean high(MagicTool magicTool) {
        magicTool.setCurrentState(HIGH);
        return true;
    }

}
