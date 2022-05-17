package id.ac.ui.cs.adpro.tutorial3.transliteration.core.tools;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LatinAeronTranslatorTest {

    LatinAeronTranslator translator = new LatinAeronTranslator();

    @Test
    public void testAeronToLatin() {
        String code = "ZF^0%ZCS_0SCHZM";
        String ret = translator.toLatin(code);

        assertEquals("aku cinta magic", ret);
    }

    @Test
    public void testLatinToAeron() {
        String text = "aku cinta magic";
        String ret = translator.toAeron(text);

        assertEquals("ZF^0%ZCS_0SCHZM", ret);
    }

    @Test
    public void testAeronAlphabetToLatin() {
        String code = "_)!@#$%^&*({}[]|:;,.<>?/=-+qwertyuiopJKLzxcvbnmasdZXCVBNMASDFGH";
        String ret = translator.toLatin(code);

        assertEquals("klmnopqrstuvwxyz.0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghij", ret);
    }

    @Test
    public void testLatinAlphabetToAeron() {
        String text = ".0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String ret = translator.toAeron(text);

        assertEquals(":;,.<>?/=-+qwertyuiopJKLzxcvbnmasdZXCVBNMASDFGH_)!@#$%^&*({}[]|", ret);
    }
}
