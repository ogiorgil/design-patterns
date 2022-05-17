package id.ac.ui.cs.advprog.tutorial4.core.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MembershipGiveawayCodeTest {
    private Class<?> membershipGiveawayCodeClass;

    @BeforeEach
    public void setUp() throws Exception {
        membershipGiveawayCodeClass = Class.forName("id.ac.ui.cs.advprog.tutorial4.core.code.MembershipGiveawayCode");
    }

    @Test
    public void testMembershipGiveawayCodeIsConcreteClass() {
        assertFalse(Modifier.isAbstract(membershipGiveawayCodeClass.getModifiers()));
    }

    @Test
    public void testMembershipGiveawayCodeIsGiveawayCode() {
        Collection<Type> classes = List.of(membershipGiveawayCodeClass.getSuperclass());

        assertTrue(classes.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial4.core.code.GiveawayCode")));
    }

}
