package id.ac.ui.cs.advancedprogramming.controlwand.core.spell;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.magictool.MagicTool;

public class ToolNone implements Spell {
    MagicTool magicTool;

    public ToolNone(MagicTool magicTool) {
        this.magicTool = magicTool;
    }

    @Override
    public boolean cast() {
        return magicTool.off();
    }

    @Override
    public void undo() {
        magicTool.undo();
    }

    @Override
    public String spellName() {
        return magicTool.getName() + ":NONE";
    }
}
