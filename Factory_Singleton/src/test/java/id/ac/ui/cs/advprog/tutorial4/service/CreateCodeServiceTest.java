package id.ac.ui.cs.advprog.tutorial4.service;

import id.ac.ui.cs.advprog.tutorial4.core.code.RedeemCode;
import id.ac.ui.cs.advprog.tutorial4.core.item.Item;
import id.ac.ui.cs.advprog.tutorial4.core.item.ItemType;
import id.ac.ui.cs.advprog.tutorial4.core.item.MembershipItem;
import id.ac.ui.cs.advprog.tutorial4.core.item.MerchItem;
import id.ac.ui.cs.advprog.tutorial4.repository.ItemRepository;
import id.ac.ui.cs.advprog.tutorial4.repository.RedeemCodeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class CreateCodeServiceTest {

    @Mock
    RedeemCode redeemCode;

    @Mock
    private RedeemCodeRepository redeemCodeRepository;

    @Mock
    private ItemRepository itemRepository;

    CreateCodeServiceImpl createCodeService;

    @BeforeEach
    public void setup() {
        createCodeService = new CreateCodeServiceImpl(itemRepository, redeemCodeRepository);
    }

    @Test
    public void testCreatePromoCode() {
        Map<String, String> data = new HashMap<>();
        data.put("discount", "10");

        Item merchItem = new MerchItem("Plushie");
        Item membershipItem = new MembershipItem("Gold");

        when(itemRepository.findByNameAndType("Plushie", ItemType.MERCH)).thenReturn(merchItem);
        when(itemRepository.findByNameAndType("Gold", ItemType.MEMBERSHIP)).thenReturn(membershipItem);

        RedeemCode merchCode = createCodeService.createCode("Merch", "Promo", "123", "Plushie", data);
        RedeemCode membershipCode = createCodeService.createCode("Membership", "Promo",null, "Gold", data);

        assertEquals(merchCode.getCode(), "123");
        assertFalse(merchCode.isRedeemed());

        assertFalse(membershipCode.isRedeemed());

        verify(itemRepository).findByNameAndType("Plushie", ItemType.MERCH);
        verify(itemRepository).findByNameAndType("Gold", ItemType.MEMBERSHIP);
        verify(redeemCodeRepository).save(merchCode);
        verify(redeemCodeRepository).save(membershipCode);
    }

    @Test
    public void testCreateGiveawayCode() {
        Map<String, String> data = new HashMap<>();
        data.put("amount", "10");

        Item merchItem = new MerchItem("Plushie");
        Item membershipItem = new MembershipItem("Gold");

        when(itemRepository.findByNameAndType("Plushie", ItemType.MERCH)).thenReturn(merchItem);
        when(itemRepository.findByNameAndType("Gold", ItemType.MEMBERSHIP)).thenReturn(membershipItem);

        RedeemCode merchCode = createCodeService.createCode("Merch", "Giveaway", "123", "Plushie", data);
        RedeemCode membershipCode = createCodeService.createCode("Membership", "Giveaway",null, "Gold", data);

        assertEquals(merchCode.getCode(), "123");
        assertFalse(merchCode.isRedeemed());

        assertFalse(membershipCode.isRedeemed());

        verify(itemRepository).findByNameAndType("Plushie", ItemType.MERCH);
        verify(itemRepository).findByNameAndType("Gold", ItemType.MEMBERSHIP);
        verify(redeemCodeRepository).save(merchCode);
        verify(redeemCodeRepository).save(membershipCode);
    }

}
