package id.ac.ui.cs.advancedprogramming.controlwand.service;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.MagicalEntity;
import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.familiar.Familiar;
import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.magictool.MagicTool;
import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.magictool.ManaIntensity;
import id.ac.ui.cs.advancedprogramming.controlwand.core.spell.*;
import id.ac.ui.cs.advancedprogramming.controlwand.repository.ControlWand;
import id.ac.ui.cs.advancedprogramming.controlwand.repository.EntityCollection;
import org.springframework.stereotype.Service;

import java.util.EnumSet;

@Service
public class ControlWandServiceImpl implements ControlWandService {
    private final ControlWand controlWand;
    private final EntityCollection entities;

    public ControlWandServiceImpl(ControlWand controlWand, EntityCollection entities) {
        this.controlWand = controlWand;
        this.entities = entities;
    }

    @Override
    public void castSpell(String spellName) {
        controlWand.cast(spellName);
    }

    @Override
    public void undoSpell() {
        controlWand.undo();
    }

    @Override
    public Iterable<String> getSpellNames() {
        return controlWand.getSpellNames();
    }

    @Override
    public Iterable<MagicalEntity> getMagicalEntities() {
        return entities.getMagicalEntities();
    }

    @Override
    public void contractFamiliar(String name) {
        Familiar familiar = new Familiar(name);
        // TODO: Register spells
        entities.registerEntity(familiar);
        controlWand.registerSpell(new SummonFamiliar(familiar));
        controlWand.registerSpell(new SealFamiliar(familiar));
    }

    @Override
    public void buyMagicTool(String name, EnumSet<ManaIntensity> requiredSpells) {
        MagicTool tool = new MagicTool(name);
        // TODO: Register spells
        entities.registerEntity(tool);
        if (requiredSpells.contains(ManaIntensity.HIGH)) {
            controlWand.registerSpell(new ToolHigh(tool));
        }
        if (requiredSpells.contains(ManaIntensity.MEDIUM)) {
            controlWand.registerSpell(new ToolMedium(tool));
        }
        if (requiredSpells.contains(ManaIntensity.LOW)) {
            controlWand.registerSpell(new ToolLow(tool));
        }
        controlWand.registerSpell(new ToolNone(tool));

    }

    @Override
    public void saveRecents(String name, int spellQuantity) {
        if (controlWand.getRecentCount() > 1) {
            controlWand.registerSpell(new ChainSpell(name, controlWand.getRecents(spellQuantity)));
        }
    }
}
