package id.ac.ui.cs.advprog.tutorial4.core.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MembershipPromoCodeTest {
    private Class<?> membershipPromoCodeClass;

    @BeforeEach
    public void setUp() throws Exception {
        membershipPromoCodeClass = Class.forName("id.ac.ui.cs.advprog.tutorial4.core.code.MembershipPromoCode");
    }

    @Test
    public void testMembershipPromoCodeIsConcreteClass() {
        assertFalse(Modifier.isAbstract(membershipPromoCodeClass.getModifiers()));
    }

    @Test
    public void testMembershipPromoCodeIsPromoCode() {
        Collection<Type> classes = List.of(membershipPromoCodeClass.getSuperclass());

        assertTrue(classes.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial4.core.code.PromoCode")));
    }

}
