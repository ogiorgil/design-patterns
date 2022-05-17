package id.ac.ui.cs.advprog.tutorial4.core.code;

import id.ac.ui.cs.advprog.tutorial4.repository.RedeemCodeRepository;

public class RedeemCodeRedeemer {
    private volatile static RedeemCodeRedeemer uniqueInstance;

    private RedeemCodeRedeemer(){}

    public static RedeemCodeRedeemer getInstance() {
        if (uniqueInstance == null) {
            synchronized (RedeemCodeRedeemer.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new RedeemCodeRedeemer();
                }
            }
        }
        return uniqueInstance;
    }

    public synchronized String redeemCode(String code, RedeemCodeRepository redeemCodeRepository) {
        RedeemCode redeemCode = redeemCodeRepository.findByCode(code);
        if (redeemCode == null)
            return "Redeem code with " + code + " does not exists!";
        return redeemCode.redeem();
    }
}
