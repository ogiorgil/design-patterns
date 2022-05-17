package id.ac.ui.cs.advprog.tutorial4.core.code;

import id.ac.ui.cs.advprog.tutorial4.repository.ItemRepository;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public abstract class CodeFactory {
    public abstract RedeemCode createCode(String itemType,
                                          String code,
                                          String itemName,
                                          Map<String, String> data,
                                          ItemRepository itemRepository);
}
