package id.ac.ui.cs.advancedprogramming.controlwand.core.spell;

public class ChainSpell implements Spell {
    Spell[] spells;
    boolean[] casted;
    String name;

    public ChainSpell(String name, Spell[] spells) {
        this.spells = spells;
        this.name = name;
    }

    @Override
    public boolean cast() {
        casted = new boolean[spells.length];
        boolean castOne = false;
        for (int i = 0; i < spells.length; i++) {
             casted[i] = spells[i].cast();
             castOne = castOne || casted[i];
        }
        return castOne;
    }

    @Override
    public void undo() {
        for (int i = spells.length-1; i >= 0; i--) {
            if (casted[i]) {
                spells[i].undo();
            }
        }
    }

    @Override
    public String spellName() {
        return name;
    }
}
