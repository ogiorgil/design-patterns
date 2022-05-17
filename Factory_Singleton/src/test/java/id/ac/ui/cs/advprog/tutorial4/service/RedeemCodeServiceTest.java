package id.ac.ui.cs.advprog.tutorial4.service;

import id.ac.ui.cs.advprog.tutorial4.core.code.RedeemCode;
import id.ac.ui.cs.advprog.tutorial4.repository.*;
import id.ac.ui.cs.advprog.tutorial4.core.item.ItemType;
import id.ac.ui.cs.advprog.tutorial4.core.item.MembershipItem;
import id.ac.ui.cs.advprog.tutorial4.core.item.MerchItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RedeemCodeServiceTest {

    @Mock
    RedeemCode redeemCode;

    @Mock
    private RedeemCodeRepository redeemCodeRepository;

    RedeemCodeServiceImpl redeemCodeService;

    @BeforeEach
    public void setup() {
        redeemCodeService = new RedeemCodeServiceImpl(redeemCodeRepository);
    }

    @Test
    public void whenRedeemCodeShouldCallFindByCode() throws Exception {
        when(redeemCodeRepository.findByCode("test")).thenReturn(redeemCode);
        redeemCodeService.redeemCode("test");
        verify(redeemCodeRepository, times(1)).findByCode("test");
    }

    @Test
    public void whenRedeemCodeErrorShouldReturnString() throws Exception {
        when(redeemCodeRepository.findByCode("test")).thenReturn(null);
        String res = redeemCodeService.redeemCode("test");
        verify(redeemCodeRepository, times(1)).findByCode("test");
        assertEquals("Redeem code with test does not exists!", res);

    }

}


