package id.ac.ui.cs.advprog.tutorial1.pricing.service;

import id.ac.ui.cs.advprog.tutorial1.pricing.core.Asuransi;
import id.ac.ui.cs.advprog.tutorial1.pricing.core.Handler;
import id.ac.ui.cs.advprog.tutorial1.pricing.core.Kurir;
import id.ac.ui.cs.advprog.tutorial1.pricing.repository.KurirRepository;
import id.ac.ui.cs.advprog.tutorial1.pricing.repository.AsuransiRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.ArrayList;

@Service
public class PricingServiceImpl implements PricingService {
    private String baseAsuransi = "Beta";
    private String baseKurir = "Kadal";

    public void setBaseAsuransi(String baseAsuransi) {
        this.baseAsuransi = baseAsuransi;
    }

    public void setBaseKurir(String baseKurir) {
        this.baseKurir = baseKurir;
    }

    @Autowired
    private KurirRepository kurirRepository;

    @Autowired
    private AsuransiRepository asuransiRepository;

    @Override
    public List<String> calculatePrice(int weight, int value) {
        // TODO
        Kurir kurir = findAppropriateKurir(weight);
        Asuransi asuransi = findAppropriateAsuransi(value);
        int hargaKurir = kurir.calculatePrice(weight);

        List<String> ret = new ArrayList<>();
        ret.add(kurir.getMessage(weight));
        ret.add(asuransi.getMessage());
        ret.add(String.format("total harga: %d + %d = %d civil credits",
                hargaKurir, asuransi.getPrice(), hargaKurir + asuransi.getPrice()));
        return ret;
    }

    private Asuransi findAppropriateAsuransi(int value) {
        return ((Handler<Asuransi>) asuransiRepository.findByName(baseAsuransi)).handle(value);
    }

    private Kurir findAppropriateKurir(int weight) {
        return ((Handler<Kurir>) kurirRepository.findByName(baseKurir)).handle(weight);
    }

}
