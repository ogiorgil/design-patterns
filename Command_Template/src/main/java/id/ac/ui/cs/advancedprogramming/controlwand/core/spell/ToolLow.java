package id.ac.ui.cs.advancedprogramming.controlwand.core.spell;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.magictool.MagicTool;

public class ToolLow implements Spell {
    MagicTool magicTool;

    public ToolLow(MagicTool magicTool) {
        this.magicTool = magicTool;
    }

    @Override
    public boolean cast() {
        return magicTool.low();
    }

    @Override
    public void undo() {
        magicTool.undo();
    }

    @Override
    public String spellName() {
        return magicTool.getName() + ":LOW";
    }
}
