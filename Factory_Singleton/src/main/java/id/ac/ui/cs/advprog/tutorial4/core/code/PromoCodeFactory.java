package id.ac.ui.cs.advprog.tutorial4.core.code;

import id.ac.ui.cs.advprog.tutorial4.core.item.Item;
import id.ac.ui.cs.advprog.tutorial4.core.item.ItemType;
import id.ac.ui.cs.advprog.tutorial4.core.util.RedeemCodeUtil;
import id.ac.ui.cs.advprog.tutorial4.repository.ItemRepository;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PromoCodeFactory extends CodeFactory {

    private volatile static PromoCodeFactory uniqueInstance;

    private PromoCodeFactory(){}

    public static PromoCodeFactory getInstance() {
        if (uniqueInstance == null) {
            synchronized (PromoCodeFactory.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new PromoCodeFactory();
                }
            }
        }
        return uniqueInstance;
    }

    @Override
    public RedeemCode createCode(String itemType, String code, String itemName, Map<String, String> data, ItemRepository itemRepository) {
        Item item;
        RedeemCode redeemCode = null;

        if (code == null || code.length() == 0) {
            code = RedeemCodeUtil.generateCode();
        }

        if (itemType.equalsIgnoreCase(ItemType.MEMBERSHIP.name())) {
            item = itemRepository.findByNameAndType(itemName, ItemType.MEMBERSHIP);
            redeemCode = new MembershipPromoCode(code, item, Integer.parseInt(data.get("discount")));
        } else if (itemType.equalsIgnoreCase(ItemType.MERCH.name())) {
            item = itemRepository.findByNameAndType(itemName, ItemType.MERCH);
            redeemCode = new MerchPromoCode(code, item, Integer.parseInt(data.get("discount")));
        }

        return redeemCode;
    }
}
