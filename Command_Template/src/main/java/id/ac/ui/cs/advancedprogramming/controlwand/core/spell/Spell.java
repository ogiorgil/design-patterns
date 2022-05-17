package id.ac.ui.cs.advancedprogramming.controlwand.core.spell;

public interface Spell {
    boolean cast();
    void undo();
    String spellName();
}
