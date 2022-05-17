package id.ac.ui.cs.advancedprogramming.inventory.core;

public class MeleeDummy extends Dummy {

    public MeleeDummy(float weight, String weapon) {
        super(weight, DummyType.MELEE, weapon);
    }

    @Override
    void adjustWeight() {
        weight += 20;
        addLog("Used armor. Weight added by 20.");
    }

    @Override
    void attack() {
        addLog("Melee attack.");
    }

    @Override
    void buff() {
        attack();
    }

    @Override
    void defense() {
        addLog("Melee defense.");
    }

}
