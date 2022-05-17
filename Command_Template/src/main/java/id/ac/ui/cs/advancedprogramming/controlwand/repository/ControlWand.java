package id.ac.ui.cs.advancedprogramming.controlwand.repository;

import id.ac.ui.cs.advancedprogramming.controlwand.core.spell.Spell;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

@Repository
public class ControlWand {

    final private Map<String, Spell> spells;

    Stack<Spell> spellHistory = new Stack<>();

    public ControlWand() {
        this.spells = new LinkedHashMap<>();
    }

    public void registerSpell(Spell spell) {
        spells.put(spell.spellName(), spell);
    }

    public void cast(String spellName) {
        // TODO: Complete Me
        if (spells.get(spellName).cast()) {
            spellHistory.push(spells.get(spellName));
        }
    }

    public void undo() {
        // TODO: Complete Me
        if (!spellHistory.isEmpty()) {
            spellHistory.pop().undo();
        }
    }

    public int getRecentCount() {
        return spellHistory.size();
    }

    public Iterable<String> getSpellNames() {
        return spells.keySet();
    }

    public Spell[] getRecents(int count) {
        Spell[] spells = new Spell[Math.min(count, spellHistory.size())];
        for (int i = spells.length-1; i >= 0; i--) {
            spells[i] = spellHistory.pop();
        }

        // restore the spellHistory stack
        for (Spell s: spells) {
            spellHistory.push(s);
        }

        return spells;
    }
}
