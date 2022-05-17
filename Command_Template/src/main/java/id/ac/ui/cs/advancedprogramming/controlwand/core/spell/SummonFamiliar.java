package id.ac.ui.cs.advancedprogramming.controlwand.core.spell;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.familiar.Familiar;

public class SummonFamiliar implements Spell {
    Familiar familiar;

    public SummonFamiliar(Familiar familiar) {
        this.familiar = familiar;
    }

    @Override
    public boolean cast() {
        return familiar.summon();
    }

    @Override
    public void undo() {
        familiar.seal();
    }

    @Override
    public String spellName() {
        return familiar.getName() + ":SUMMONED";
    }
}
