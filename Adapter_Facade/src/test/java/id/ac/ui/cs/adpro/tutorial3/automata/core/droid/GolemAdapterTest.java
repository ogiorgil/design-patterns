package id.ac.ui.cs.adpro.tutorial3.automata.core.droid;

import id.ac.ui.cs.adpro.tutorial3.automata.core.golem.IronGolem;
import id.ac.ui.cs.adpro.tutorial3.automata.core.golem.SnowGolem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GolemAdapterTest {

    private Class<?> golemAdapterClass;
    private GolemAdapter ironGolem;
    private GolemAdapter snowGolem;

    @BeforeEach
    public void setUp() throws Exception {
        golemAdapterClass = Class.forName("id.ac.ui.cs.adpro.tutorial3.automata.core.droid.GolemAdapter");
        ironGolem = new GolemAdapter(new IronGolem("Ogre"));
        snowGolem = new GolemAdapter(new SnowGolem("Frosty"));
    }

    @Test
    public void testGolemAdapterIsConcreteClass() {
        assertFalse(Modifier.isAbstract(golemAdapterClass.getModifiers()));
    }

    @Test
    public void testGolemAdapterIsADroid() {
        Collection<Type> interfaces = Arrays.asList(golemAdapterClass.getInterfaces());

        assertTrue(interfaces.stream()
            .anyMatch(type -> type.getTypeName()
                .equals("id.ac.ui.cs.adpro.tutorial3.automata.core.droid.Droid")));
    }

    @Test
    public void testGolemAdapterOverrideLiftItemMethod() throws Exception {
        Method liftItem = golemAdapterClass.getDeclaredMethod("liftItem", String.class);

        assertEquals("java.lang.String",
            liftItem.getGenericReturnType().getTypeName());
        assertEquals(1, liftItem.getParameterCount());
        assertTrue(Modifier.isPublic(liftItem.getModifiers()));
    }

    @Test
    public void testIronGolemLiftItemIsCorrectlyImplemented() {
        String result = ironGolem.liftItem("box");
        assertEquals("Carefully lifting box", result);
    }

    @Test
    public void testSnowGolemLiftItemIsCorrectlyImplemented() {
        String result = snowGolem.liftItem("box");
        assertEquals("Lifting box with two hands", result);
    }

    @Test
    public void testGolemAdapterOverrideCountItemMethod() throws Exception {
        Class<?>[] countItemArgs = new Class[2];
        countItemArgs[0] = List.class;
        countItemArgs[1] = String.class;
        Method countItem = golemAdapterClass.getDeclaredMethod("countItem", countItemArgs);

        assertEquals("java.lang.String",
            countItem.getGenericReturnType().getTypeName());
        assertEquals(2, countItem.getParameterCount());
        assertTrue(Modifier.isPublic(countItem.getModifiers()));
    }

    @Test
    public void testIronGolemCountItemIsCorrectlyImplemented() {
        List<String> items = new ArrayList<>();
        items.add("Homa");
        items.add("Box");
        String result = ironGolem.countItem(items, "Box");
        assertEquals("Golem counted 1 Box", result);
    }

    @Test
    public void testSnowGolemCountItemIsCorrectlyImplemented() {
        List<String> items = new ArrayList<>();
        items.add("Homa");
        items.add("Box");
        String result = snowGolem.countItem(items, "Box");
        assertEquals("Golem counted 1 Box", result);
    }

    @Test
    public void testGolemAdapterOverrideUseTransporterMethod() throws Exception {
        Method useTransporter = golemAdapterClass.getDeclaredMethod("useTransporter");

        assertEquals("java.lang.String",
            useTransporter.getGenericReturnType().getTypeName());
        assertEquals(0, useTransporter.getParameterCount());
        assertTrue(Modifier.isPublic(useTransporter.getModifiers()));
    }

    @Test
    public void testIronGolemUseTransporterIsCorrectlyImplemented() {
        String result = ironGolem.useTransporter();
        assertEquals("Tossing item with one hand", result);
    }

    @Test
    public void testSnowGolemUseTransporterIsCorrectlyImplemented() {
        String result = snowGolem.useTransporter();
        assertEquals("Tossing item with two hand", result);
    }

    @Test
    public void testGolemAdapterOverrideUseCraneMethod() throws Exception {
        Method useCrane = golemAdapterClass.getDeclaredMethod("useCrane");

        assertEquals("java.lang.String",
            useCrane.getGenericReturnType().getTypeName());
        assertEquals(0, useCrane.getParameterCount());
        assertTrue(Modifier.isPublic(useCrane.getModifiers()));
    }

    @Test
    public void testIronGolemUseCraneIsCorrectlyImplemented() {
        String result = ironGolem.useCrane();
        assertEquals("Punching CraneLever", result);
    }

    @Test
    public void testSnowGolemUseCraneIsCorrectlyImplemented() {
        String result = snowGolem.useCrane();
        assertEquals("Punching CraneLever", result);
    }

    @Test
    public void testGolemAdapterOverrideGetNameMethod() throws Exception {
        Method getName = golemAdapterClass.getDeclaredMethod("getName");

        assertEquals("java.lang.String",
            getName.getGenericReturnType().getTypeName());
        assertEquals(0, getName.getParameterCount());
        assertTrue(Modifier.isPublic(getName.getModifiers()));
    }

    @Test
    public void testIronGolemGetNameIsCorrectlyImplemented() {
        String result = ironGolem.getName();
        assertEquals("Ogre", result);
    }

    @Test
    public void testSnowGolemGetNameIsCorrectlyImplemented() {
        String result = snowGolem.getName();
        assertEquals("Frosty", result);
    }

    @Test
    public void testIronGolemGetTypeIsCorrectlyImplemented() {
        String result = ironGolem.getType();
        assertEquals("Adapted Golem", result);
    }

    @Test
    public void testSnowGolemGetTypeIsCorrectlyImplemented() {
        String result = snowGolem.getType();
        assertEquals("Adapted Golem", result);
    }
}
