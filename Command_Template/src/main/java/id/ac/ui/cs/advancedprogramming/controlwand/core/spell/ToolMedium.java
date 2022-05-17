package id.ac.ui.cs.advancedprogramming.controlwand.core.spell;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.magictool.MagicTool;

public class ToolMedium implements Spell {
    MagicTool magicTool;

    public ToolMedium(MagicTool magicTool) {
        this.magicTool = magicTool;
    }

    @Override
    public boolean cast() {
        return magicTool.medium();
    }

    @Override
    public void undo() {
        magicTool.undo();
    }

    @Override
    public String spellName() {
        return magicTool.getName() + ":MEDIUM";
    }
}
