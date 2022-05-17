package id.ac.ui.cs.advancedprogramming.inventory.core;

public class RangedDummy extends Dummy {
    protected boolean weaponActivated;

    public RangedDummy(float weight, String weapon) {
        super(weight, DummyType.RANGED, weapon);
        weaponActivated = false;
    }

    @Override
    void adjustWeight() {
        weight = (float) (0.8 * weight);
        addLog("Becomes nimble. Weight reduced by 20%.");
    }

    @Override
    void activate() {
        activated = true;
        addLog("Dummy activated.");
        weaponActivated = true;
        addLog("Ranged weapon activated.");
    }

    @Override
    void attack() {
        addLog("Ranged attack.");
    }

    @Override
    void buff() {
        addLog("Ranged buff.");
    }

    @Override
    void defense() {

    }

    @Override
    void deactivate() {
        weaponActivated = false;
        addLog("Ranged weapon deactivated.");
        activated = false;
        addLog("Dummy deactivated.");
    }

}
