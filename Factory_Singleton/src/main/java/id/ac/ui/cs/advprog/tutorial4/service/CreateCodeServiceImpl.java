package id.ac.ui.cs.advprog.tutorial4.service;

import id.ac.ui.cs.advprog.tutorial4.core.code.*;
import id.ac.ui.cs.advprog.tutorial4.core.item.Item;
import id.ac.ui.cs.advprog.tutorial4.core.item.ItemType;
import id.ac.ui.cs.advprog.tutorial4.repository.ItemRepository;
import id.ac.ui.cs.advprog.tutorial4.repository.RedeemCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CreateCodeServiceImpl implements CreateCodeService {

    private final ItemRepository itemRepository;

    private final RedeemCodeRepository redeemCodeRepository;

    /**
     *
     * @param itemType String of {@link ItemType}.
     * @param codeType String of {@link CodeType}.
     * @param code Custom code.
     * @param itemName Name of the item.
     * @param data Map of additional data.
     *             Key "amount" should exist for Giveaway (see {@link GiveawayCode#getItemAmount()}).
     *             Key "discount" should exist for Promo (see {@link PromoCode#getDiscountAmount()}).
     *
     * @return {@link RedeemCode}
     */
    @Override
    public RedeemCode createCode(String itemType, String codeType, String code, String itemName, Map<String, String> data) {

        //TODO
        CodeFactory promoCodeFactory = PromoCodeFactory.getInstance();
        CodeFactory giveawayCodeFactory = GiveawayCodeFactory.getInstance();

        RedeemCode redeemCode = null;

        if (codeType.equalsIgnoreCase(CodeType.PROMO.name())) {
            redeemCode = promoCodeFactory.createCode(itemType, code, itemName, data, itemRepository);
        } else if (codeType.equalsIgnoreCase(CodeType.GIVEAWAY.name())) {
            redeemCode = giveawayCodeFactory.createCode(itemType, code, itemName, data, itemRepository);
        }

        redeemCodeRepository.save(redeemCode);
        return redeemCode;
    }
}
