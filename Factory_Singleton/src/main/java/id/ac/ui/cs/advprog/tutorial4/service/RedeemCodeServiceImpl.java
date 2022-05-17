package id.ac.ui.cs.advprog.tutorial4.service;

import id.ac.ui.cs.advprog.tutorial4.core.code.RedeemCodeRedeemer;
import id.ac.ui.cs.advprog.tutorial4.repository.RedeemCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedeemCodeServiceImpl implements RedeemCodeService {

    private final RedeemCodeRepository redeemCodeRepository;

    @Override
    public String redeemCode(String code)  {
        RedeemCodeRedeemer redeemer = RedeemCodeRedeemer.getInstance();
        return redeemer.redeemCode(code, redeemCodeRepository);
    }
}
