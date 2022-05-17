package id.ac.ui.cs.advancedprogramming.controlwand.core.entity.magictool;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.MagicalEntity;
import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.MagicalEntityState;

import java.util.Stack;

public class MagicTool extends MagicalEntity {
    Stack<MagicalEntityState> manaIntensityHistory;

    public MagicTool(String name) {
        super(name);
        currentState = ManaIntensity.NONE;
        manaIntensityHistory = new Stack<>();
    }

    @Override
    protected String defineState(MagicalEntityState state) {
        return this.name + "'s mana intensity has been set to " + state.toString();
    }

    @Override
    public void setCurrentState(MagicalEntityState currentState) {
        manaIntensityHistory.push(this.currentState);
        this.currentState = currentState;
        stateHistory.add(currentState);
    }

    public boolean off() {
        // TODO: Complete Me
        return ((ManaIntensity) currentState).off(this);
    }

    public boolean low() {
        // TODO: Complete Me
        return ((ManaIntensity) currentState).low(this);
    }

    public boolean medium() {
        // TODO: Complete Me
        return ((ManaIntensity) currentState).medium(this);
    }

    public boolean high() {
        // TODO: Complete Me
        return ((ManaIntensity) currentState).high(this);
    }

    public void undo() {
        if (!manaIntensityHistory.isEmpty()) {
            setCurrentState(manaIntensityHistory.pop());
            manaIntensityHistory.pop();
        }
    }
}
