package id.ac.ui.cs.adpro.tutorial3.automata.core.droid;

import id.ac.ui.cs.adpro.tutorial3.automata.core.fluids.Slime;
import id.ac.ui.cs.adpro.tutorial3.automata.core.fluids.Symbiote;
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

public class FluidsAdapterTest {

    private Class<?> fluidsAdapterClass;
    private FluidsAdapter slime;
    private FluidsAdapter symbiote;

    @BeforeEach
    public void setUp() throws Exception {
        fluidsAdapterClass = Class.forName("id.ac.ui.cs.adpro.tutorial3.automata.core.droid.FluidsAdapter");
        slime = new FluidsAdapter(new Slime("Bob"));
        symbiote = new FluidsAdapter(new Symbiote("Symmie"));
    }

    @Test
    public void testFluidsAdapterIsConcreteClass() {
        assertFalse(Modifier.isAbstract(fluidsAdapterClass.getModifiers()));
    }

    @Test
    public void testFluidsAdapterIsADroid() {
        Collection<Type> interfaces = Arrays.asList(fluidsAdapterClass.getInterfaces());

        assertTrue(interfaces.stream()
            .anyMatch(type -> type.getTypeName()
                .equals("id.ac.ui.cs.adpro.tutorial3.automata.core.droid.Droid")));
    }

    @Test
    public void testFluidsAdapterOverrideLiftItemMethod() throws Exception {
        Method liftItem = fluidsAdapterClass.getDeclaredMethod("liftItem", String.class);

        assertEquals("java.lang.String",
            liftItem.getGenericReturnType().getTypeName());
        assertEquals(1, liftItem.getParameterCount());
        assertTrue(Modifier.isPublic(liftItem.getModifiers()));
    }

    @Test
    public void testSlimeLiftItemIsCorrectlyImplemented() {
        String result = slime.liftItem("box");
        assertEquals("Pushing box Up", result);
    }

    @Test
    public void testSymbioteiftItemIsCorrectlyImplemented() {
        String result = symbiote.liftItem("box");
        assertEquals("Pushing box Up", result);
    }

    @Test
    public void testFluidsAdapterOverrideCountItemMethod() throws Exception {
        Class<?>[] countItemArgs = new Class[2];
        countItemArgs[0] = List.class;
        countItemArgs[1] = String.class;
        Method countItem = fluidsAdapterClass.getDeclaredMethod("countItem", countItemArgs);

        assertEquals("java.lang.String",
            countItem.getGenericReturnType().getTypeName());
        assertEquals(2, countItem.getParameterCount());
        assertTrue(Modifier.isPublic(countItem.getModifiers()));
    }

    @Test
    public void testSlimeCountItemIsCorrectlyImplemented() {
        List<String> items = new ArrayList<>();
        items.add("Homa");
        items.add("Box");
        String result = slime.countItem(items, "Box");
        assertEquals("Fluid counted 1 Box. Merging bodies", result);
    }

    @Test
    public void testSymbioteCountItemIsCorrectlyImplemented() {
        List<String> items = new ArrayList<>();
        items.add("Homa");
        items.add("Box");
        String result = symbiote.countItem(items, "Box");
        assertEquals("Fluid counted 1 Box. Collecting bodies", result);
    }

    @Test
    public void testFluidsAdapterOverrideUseTransporterMethod() throws Exception {
        Method useTransporter = fluidsAdapterClass.getDeclaredMethod("useTransporter");

        assertEquals("java.lang.String",
            useTransporter.getGenericReturnType().getTypeName());
        assertEquals(0, useTransporter.getParameterCount());
        assertTrue(Modifier.isPublic(useTransporter.getModifiers()));
    }

    @Test
    public void testSlimeUseTransporterIsCorrectlyImplemented() {
        String result = slime.useTransporter();
        assertEquals("Shape shift into Transporter", result);
    }

    @Test
    public void testSymbioteUseTransporterIsCorrectlyImplemented() {
        String result = symbiote.useTransporter();
        assertEquals("Changed shape into Transporter", result);
    }

    @Test
    public void testFluidsAdapterOverrideUseCraneMethod() throws Exception {
        Method useCrane = fluidsAdapterClass.getDeclaredMethod("useCrane");

        assertEquals("java.lang.String",
            useCrane.getGenericReturnType().getTypeName());
        assertEquals(0, useCrane.getParameterCount());
        assertTrue(Modifier.isPublic(useCrane.getModifiers()));
    }

    @Test
    public void testSlimeUseCraneIsCorrectlyImplemented() {
        String result = slime.useCrane();
        assertEquals("Shape shift into Crane", result);
    }

    @Test
    public void testSymbioteUseCraneIsCorrectlyImplemented() {
        String result = symbiote.useCrane();
        assertEquals("Changed shape into Crane", result);
    }

    @Test
    public void testFluidsAdapterOverrideGetNameMethod() throws Exception {
        Method getName = fluidsAdapterClass.getDeclaredMethod("getName");

        assertEquals("java.lang.String",
            getName.getGenericReturnType().getTypeName());
        assertEquals(0, getName.getParameterCount());
        assertTrue(Modifier.isPublic(getName.getModifiers()));
    }

    @Test
    public void testSlimeGetNameIsCorrectlyImplemented() {
        String result = slime.getName();
        assertEquals("Bob", result);
    }

    @Test
    public void testSymbioteGetNameIsCorrectlyImplemented() {
        String result = symbiote.getName();
        assertEquals("Symmie", result);
    }

    @Test
    public void testSlimeGetTypeIsCorrectlyImplemented() {
        String result = slime.getType();
        assertEquals("Adapted Fluids", result);
    }

    @Test
    public void testSymbioteGetTypeIsCorrectlyImplemented() {
        String result = symbiote.getType();
        assertEquals("Adapted Fluids", result);
    }
}
