package id.ac.ui.cs.advancedprogramming.controlwand.core.spell;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.familiar.Familiar;

public class SealFamiliar implements Spell {
    Familiar familiar;

    public SealFamiliar(Familiar familiar) {
        this.familiar = familiar;
    }

    @Override
    public boolean cast() {
        return familiar.seal();
    }

    @Override
    public void undo() {
        familiar.summon();
    }

    @Override
    public String spellName() {
        return familiar.getName() + ":SEALED";
    }
}
