package id.ac.ui.cs.advprog.tutorial4.core.code;

import id.ac.ui.cs.advprog.tutorial4.repository.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CodeFactoryTest {
    private Class<?> codeFactoryClass;

    @BeforeEach
    public void setup() throws Exception {
        codeFactoryClass = Class.forName("id.ac.ui.cs.advprog.tutorial4.core.code.CodeFactory");
    }

    @Test
    public void testCodeFactoryIsPublicAbstractClass() {
        int classModifiers = codeFactoryClass.getModifiers();

        assertTrue(Modifier.isPublic(classModifiers));
        assertTrue(Modifier.isAbstract(classModifiers));
    }

    @Test
    public void testCodeFactoryHasCreateCodeAbstractMethod() throws Exception {
        Method createCode = codeFactoryClass.getDeclaredMethod("createCode",
                String.class,
                String.class,
                String.class,
                Map.class,
                ItemRepository.class);

        int methodModifiers = createCode.getModifiers();

        assertTrue(Modifier.isPublic(methodModifiers));
        assertTrue(Modifier.isAbstract(methodModifiers));
        assertEquals(5, createCode.getParameterCount());
    }

}
