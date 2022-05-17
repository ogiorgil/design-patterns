package id.ac.ui.cs.advancedprogramming.controlwand.service;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.MagicalEntity;
import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.magictool.ManaIntensity;

import java.util.EnumSet;

public interface ControlWandService {
    void castSpell(String spellName);
    void undoSpell();
    Iterable<String> getSpellNames();
    Iterable<MagicalEntity> getMagicalEntities();
    void contractFamiliar(String name);
    void buyMagicTool(String name, EnumSet<ManaIntensity> requiredSpells);
    void saveRecents(String name, int spellQuantity);
}
