package id.ac.ui.cs.advancedprogramming.inventory.core;

import java.util.ArrayList;
import java.util.List;

public abstract class Dummy {
    protected DummyType type;
    protected String weapon;
    protected List<String> dummyLog;
    protected float weight;
    protected boolean activated;

    public Dummy(float weight, DummyType type, String weapon) {
        this.weight = weight;
        this.type = type;
        this.weapon = weapon;
        activated = false;
        dummyLog = new ArrayList<>();
    }

    public DummyType getType() {
        return type;
    }

    public String getWeapon() {
        return weapon;
    }

    public float getWeight() {
        return weight;
    }

    public List<String> getDummyLog() {
        return dummyLog;
    }

    public void addLog(String log) {
        dummyLog.add(log);
    }

    void adjustWeight() {

    }

    void activate() {
        addLog("Dummy activated.");
        activated = true;
    }

    void deactivate() {
        activated = false;
        addLog("Dummy deactivated.");
    }

    abstract void attack();
    abstract void buff();
    abstract void defense();

    final void testMoveset() {
        attack();
        attack();
        buff();
        attack();
        defense();
        attack();
        defense();
    }

    public final void qualityCheck() {
        // TODO: Complete Me
        adjustWeight();
        activate();
        testMoveset();
        deactivate();
    }
}
