package id.ac.ui.cs.advprog.tutorial4.core.code;

import id.ac.ui.cs.advprog.tutorial4.core.item.Item;
import id.ac.ui.cs.advprog.tutorial4.core.item.ItemType;
import id.ac.ui.cs.advprog.tutorial4.core.item.MembershipItem;
import id.ac.ui.cs.advprog.tutorial4.core.item.MerchItem;
import id.ac.ui.cs.advprog.tutorial4.repository.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PromoCodeFactoryTest {
    private Class<?> promoCodeFactoryClass;
    private CodeFactory promoCodeFactory;

    @BeforeEach
    public void setup() throws Exception {
        promoCodeFactoryClass = Class.forName("id.ac.ui.cs.advprog.tutorial4.core.code.PromoCodeFactory");
        promoCodeFactory = PromoCodeFactory.getInstance();
    }

    @Test
    public void testPromoCodeFactoryIsPublicConcreteClass() {
        int classModifiers = promoCodeFactoryClass.getModifiers();

        assertTrue(Modifier.isPublic(classModifiers));
        assertFalse(Modifier.isAbstract(classModifiers));
    }

    @Test
    public void testPromoCodeFactoryIsCodeFactory() {
        Type superClass = promoCodeFactoryClass.getSuperclass();

        assertEquals(superClass.getTypeName(), "id.ac.ui.cs.advprog.tutorial4.core.code.CodeFactory");
    }


    @Test
    public void testPromoCodeFactoryOverrideCreateCodeMethod() throws Exception {
        Method createCode = promoCodeFactoryClass.getDeclaredMethod("createCode",
                String.class,
                String.class,
                String.class,
                Map.class,
                ItemRepository.class);

        int methodModifiers = createCode.getModifiers();

        assertTrue(Modifier.isPublic(methodModifiers));
        assertEquals(5, createCode.getParameterCount());
    }

    @Test
    public void testPromoCodeFactoryIsSingleton() {
        assertSame(promoCodeFactory, PromoCodeFactory.getInstance());
    }

    @Test
    public void testCreateMerchPromoCode() {
        Map<String, String> data = new HashMap<>();
        data.put("discount", "10");

        Item merchItem = new MerchItem("Plushie");
        Item merchItem2 = new MerchItem("item");

        ItemRepository itemRepository = Mockito.mock(ItemRepository.class);
        when(itemRepository.findByNameAndType("Plushie", ItemType.MERCH)).thenReturn(merchItem);
        when(itemRepository.findByNameAndType("item", ItemType.MERCH)).thenReturn(merchItem2);

        RedeemCode merchCode = promoCodeFactory.createCode("Merch", "123", "Plushie", data, itemRepository);
        RedeemCode merchCode2 = promoCodeFactory.createCode("Merch", null, "item", data, itemRepository);

        assertEquals(merchCode.getCode(), "123");
        assertFalse(merchCode.isRedeemed());

        assertFalse(merchCode2.isRedeemed());

        verify(itemRepository).findByNameAndType("Plushie", ItemType.MERCH);
        verify(itemRepository).findByNameAndType("item", ItemType.MERCH);
    }

    @Test
    public void testCreateMembershipPromoCode() {
        Map<String, String> data = new HashMap<>();
        data.put("discount", "10");

        Item membershipItem = new MembershipItem("Gold");
        Item membershipItem2 = new MembershipItem("Diamond");

        ItemRepository itemRepository = Mockito.mock(ItemRepository.class);
        when(itemRepository.findByNameAndType("Gold", ItemType.MERCH)).thenReturn(membershipItem);
        when(itemRepository.findByNameAndType("Diamond", ItemType.MEMBERSHIP)).thenReturn(membershipItem2);

        RedeemCode membershipCode = promoCodeFactory.createCode("Membership", "123", "Gold", data, itemRepository);
        RedeemCode membershipCode2 = promoCodeFactory.createCode("Membership", null, "Diamond", data, itemRepository);

        assertEquals(membershipCode.getCode(), "123");
        assertFalse(membershipCode2.isRedeemed());

        assertFalse(membershipCode.isRedeemed());

        verify(itemRepository).findByNameAndType("Gold", ItemType.MEMBERSHIP);
        verify(itemRepository).findByNameAndType("Diamond", ItemType.MEMBERSHIP);
    }

}
