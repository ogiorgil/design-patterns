package id.ac.ui.cs.adpro.tutorial3.transliteration.core.tools;

import id.ac.ui.cs.adpro.tutorial3.transliteration.core.lingua.Aeron;
import id.ac.ui.cs.adpro.tutorial3.transliteration.core.lingua.Latin;
import id.ac.ui.cs.adpro.tutorial3.transliteration.core.lingua.Lingua;
import id.ac.ui.cs.adpro.tutorial3.transliteration.core.util.Spell;

import java.util.List;

public class LatinAeronTranslator {
    private final Lingua AERON = Aeron.getInstance();
    private final Lingua LATIN = Latin.getInstance();
    Cipher cipher = new Cipher();
    Shifter shifter = new Shifter();
    Parser aeronParser = new Parser(AERON);
    Parser latinParser = new Parser(LATIN);
    Joiner aeronJoiner = new Joiner(AERON);
    Joiner latinJoiner = new Joiner(LATIN);

    public String toLatin(String code) {
        List<Spell> spells = aeronParser.parseSentence(code);
        for (int i = 0; i < spells.size(); i++) {
            spells.set(i, cipher.decode(spells.get(i)));
            spells.set(i, shifter.shift(spells.get(i), 3));
            spells.set(i, LinguaTranslator.translate(spells.get(i), LATIN));
        }
        return latinJoiner.join(spells);
    }

    public String toAeron(String text) {
        List<Spell> spells = latinParser.parseSentence(text);
        for (int i = 0; i < spells.size(); i++) {
            spells.set(i, LinguaTranslator.translate(spells.get(i), AERON));
            spells.set(i, shifter.shift(spells.get(i), -3));
            spells.set(i, cipher.encode(spells.get(i)));
        }
        return aeronJoiner.join(spells);
    }
}
