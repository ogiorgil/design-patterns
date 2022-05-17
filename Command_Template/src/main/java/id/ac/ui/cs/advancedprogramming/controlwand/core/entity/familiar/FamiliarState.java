package id.ac.ui.cs.advancedprogramming.controlwand.core.entity.familiar;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.MagicalEntityState;

public enum FamiliarState implements MagicalEntityState {
    SEALED {
        @Override
        public boolean seal(Familiar familiar) {
            return false;
        }

        @Override
        public boolean summon(Familiar familiar) {
            familiar.setCurrentState(SUMMONED);
            return true;
        }

        @Override
        public String getName() {
            return "SEALED";
        }
    }, SUMMONED {
        @Override
        public boolean seal(Familiar familiar) {
            familiar.setCurrentState(SEALED);
            return true;
        }

        @Override
        public boolean summon(Familiar familiar) {
            return false;
        }

        @Override
        public String getName() {
            return "SUMMONED";
        }
    };

    public abstract boolean seal(Familiar familiar);
    public abstract boolean summon(Familiar familiar);
}
