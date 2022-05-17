package id.ac.ui.cs.advprog.tutorial4.core.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MerchGiveawayCodeTest {
    private Class<?> merchGiveawayCodeClass;

    @BeforeEach
    public void setUp() throws Exception {
        merchGiveawayCodeClass = Class.forName("id.ac.ui.cs.advprog.tutorial4.core.code.MerchGiveawayCode");
    }

    @Test
    public void testMerchGiveawayCodeIsConcreteClass() {
        assertFalse(Modifier.isAbstract(merchGiveawayCodeClass.getModifiers()));
    }

    @Test
    public void testMerchGiveawayCodeIsGiveawayCode() {
        Collection<Type> classes = List.of(merchGiveawayCodeClass.getSuperclass());

        assertTrue(classes.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial4.core.code.GiveawayCode")));
    }

}
