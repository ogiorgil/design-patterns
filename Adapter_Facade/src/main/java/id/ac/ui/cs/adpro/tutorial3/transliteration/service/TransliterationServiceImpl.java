package id.ac.ui.cs.adpro.tutorial3.transliteration.service;

import id.ac.ui.cs.adpro.tutorial3.transliteration.core.lingua.Aeron;
import id.ac.ui.cs.adpro.tutorial3.transliteration.core.lingua.Latin;
import id.ac.ui.cs.adpro.tutorial3.transliteration.core.lingua.Lingua;
import id.ac.ui.cs.adpro.tutorial3.transliteration.core.tools.*;
import id.ac.ui.cs.adpro.tutorial3.transliteration.core.util.Spell;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransliterationServiceImpl implements TransliterationService {

    private boolean recentRequestType;
    private String recentRequestValue;
    private LatinAeronTranslator latinAeronTranslator;

    public TransliterationServiceImpl() {
        // TODO: complete this constructor
        latinAeronTranslator = new LatinAeronTranslator();
    }

    /**
     * Translate from Latin to Archaic
     */
    @Override
    public String encode(String text) {
        // TODO: complete this method
        return latinAeronTranslator.toAeron(text);
    }

    /**
     * Translate from Archaic to Latin
    */
    @Override
    public String decode(String code) {
        // TODO: complete this method
        return latinAeronTranslator.toLatin(code);
    }

    @Override
    public void setRequestType(String requestType) {
        this.recentRequestType = requestType.equals("encode");
    }

    @Override
    public boolean isRequestEncode() {
        return recentRequestType;
    }

    @Override
    public String getRequestValue() {
        return recentRequestValue;
    }

    @Override
    public void setRequestValue(String requestValue) {
        recentRequestValue = requestValue;
    }

    @Override
    public String processAeronCipher(String text, String type) {

        Cipher c = new Cipher();
        Spell s = new Spell(text, Aeron.getInstance());
        if(type.equals("encode")) {
            return c.encode(s).getText();
        } else {
            return c.decode(s).getText();
        }
    }

    @Override
    public String processAeronShifter(String text, int shift) {
        Shifter shifter = new Shifter();
        Spell s = new Spell(text, Aeron.getInstance());
        return shifter.shift(s, shift).getText();
    }

}
