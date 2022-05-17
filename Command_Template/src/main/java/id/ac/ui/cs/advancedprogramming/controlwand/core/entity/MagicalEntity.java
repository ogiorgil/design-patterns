package id.ac.ui.cs.advancedprogramming.controlwand.core.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class MagicalEntity {
    protected String name;
    protected MagicalEntityState currentState;
    protected List<MagicalEntityState> stateHistory;

    public MagicalEntity(String name) {
        this.name = name;
        stateHistory = new ArrayList<>();
    }

    public void setCurrentState(MagicalEntityState currentState) {
        this.currentState = currentState;
        stateHistory.add(currentState);
    }

    protected abstract String defineState(MagicalEntityState state);

    public String getName() {
        return name;
    }

    public MagicalEntityState getCurrentState() {
        return currentState;
    }

    public List<String> getLifeArchive() {
        return stateHistory.stream().map(this::defineState).collect(Collectors.toList());
    }

    public void undo() {
        // TODO: Complete Me
    }
}
