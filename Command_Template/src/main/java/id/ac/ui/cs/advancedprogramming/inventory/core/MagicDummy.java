package id.ac.ui.cs.advancedprogramming.inventory.core;

public class MagicDummy extends Dummy {
    boolean weaponActivated;

    public MagicDummy(float weight, String weapon) {
        super(weight, DummyType.MAGIC, weapon);
        weaponActivated = false;
    }

    @Override
    void activate() {
        activated = true;
        addLog("Dummy activated.");
        weaponActivated = true;
        addLog("Magic weapon activated.");
    }

    @Override
    void attack() {
        addLog("Magic attack.");
        buff();
    }

    @Override
    void buff() {
        addLog("Magic buff.");
    }

    @Override
    void defense() {
        addLog("Magic defense.");
    }

    @Override
    void deactivate() {
        weaponActivated = false;
        addLog("Magic weapon deactivated.");
        activated = false;
        addLog("Dummy deactivated.");
    }

}
