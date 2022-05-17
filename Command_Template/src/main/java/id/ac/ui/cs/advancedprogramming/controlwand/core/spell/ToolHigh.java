package id.ac.ui.cs.advancedprogramming.controlwand.core.spell;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.magictool.MagicTool;

public class ToolHigh implements Spell {
    MagicTool magicTool;

    public ToolHigh(MagicTool magicTool) {
        this.magicTool = magicTool;
    }

    @Override
    public boolean cast() {
        return magicTool.high();
    }

    @Override
    public void undo() {
        magicTool.undo();
    }

    @Override
    public String spellName() {
        return magicTool.getName() + ":HIGH";
    }
}
