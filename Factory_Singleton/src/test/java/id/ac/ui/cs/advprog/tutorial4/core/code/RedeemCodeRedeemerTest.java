package id.ac.ui.cs.advprog.tutorial4.core.code;

import id.ac.ui.cs.advprog.tutorial4.core.item.Item;
import id.ac.ui.cs.advprog.tutorial4.core.item.ItemType;
import id.ac.ui.cs.advprog.tutorial4.core.item.MerchItem;
import id.ac.ui.cs.advprog.tutorial4.repository.ItemRepository;
import id.ac.ui.cs.advprog.tutorial4.repository.RedeemCodeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class RedeemCodeRedeemerTest {
    private RedeemCodeRedeemer redeemer;

    @BeforeEach
    private void setup() {
        redeemer = RedeemCodeRedeemer.getInstance();
    }

    @Test
    public void testRedeemCodeRedeemerIsSingleton() {
        assertSame(redeemer, RedeemCodeRedeemer.getInstance());
    }

    @Test
    public void testRedeemPromoCode() {
        RedeemCodeRepository redeemCodeRepository = Mockito.mock(RedeemCodeRepository.class);

        Map<String, String> data = new HashMap<>();
        data.put("discount", "10");

        Item merchItem = new MerchItem("Plushie");

        ItemRepository itemRepository = Mockito.mock(ItemRepository.class);
        when(itemRepository.findByNameAndType("Plushie", ItemType.MERCH)).thenReturn(merchItem);

        PromoCodeFactory promoCodeFactory = PromoCodeFactory.getInstance();
        RedeemCode giveawayCode = promoCodeFactory.createCode("Merch", "123", "Plushie", data, itemRepository);
        when(redeemCodeRepository.findByCode("123")).thenReturn(giveawayCode);

        assertEquals("Congratulation! You get a 10.0% discount on Plushie", redeemer.redeemCode("123", redeemCodeRepository));
        assertEquals("Redeem code 123 has been redeemed and can't be used anymore.", redeemer.redeemCode("123", redeemCodeRepository));
    }

    @Test
    public void testRedeemGiveawayCode() {
        RedeemCodeRepository redeemCodeRepository = Mockito.mock(RedeemCodeRepository.class);

        Map<String, String> data = new HashMap<>();
        data.put("amount", "10");

        Item merchItem = new MerchItem("Plushie");

        ItemRepository itemRepository = Mockito.mock(ItemRepository.class);
        when(itemRepository.findByNameAndType("Plushie", ItemType.MERCH)).thenReturn(merchItem);

        GiveawayCodeFactory giveawayCodeFactory = GiveawayCodeFactory.getInstance();
        RedeemCode giveawayCode = giveawayCodeFactory.createCode("Merch", "123", "Plushie", data, itemRepository);
        when(redeemCodeRepository.findByCode("123")).thenReturn(giveawayCode);

        assertEquals("Congratulation! You get 10 Plushie", redeemer.redeemCode("123", redeemCodeRepository));
        assertEquals("Redeem code 123 has been redeemed and can't be used anymore.", redeemer.redeemCode("123", redeemCodeRepository));
    }
}
