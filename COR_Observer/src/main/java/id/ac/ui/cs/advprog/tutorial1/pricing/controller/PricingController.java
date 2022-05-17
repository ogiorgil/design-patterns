package id.ac.ui.cs.advprog.tutorial1.pricing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import id.ac.ui.cs.advprog.tutorial1.pricing.service.PricingService;

import java.util.List;
import java.util.ArrayList;

@Controller
@RequestMapping(path = "/pricing")
public class PricingController {

    @Autowired
    private PricingService pricingService;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public String pricingHome(Model model) {
        return "pricing/home";
    }

    //ToDo: Fill with a correct method
    @RequestMapping(path = "/calculate-price", method= RequestMethod.POST)
    public String calculatePrice(Model model,
            @RequestParam(value = "weight", required = true) int weight,
            @RequestParam(value = "value", required = true) int value) {
        
        // TODO: display the calculated price and used services

        List<String> ret = pricingService.calculatePrice(weight, value);
//        ret.add("Menggunakan Kurir Kadal");
//        ret.add("Harga jasa kurir: 5 x 10 = 50 civil credits");
//        ret.add("Menggunakan Asuransi Alpha");
//        ret.add("Harga jasa asuransi: 1000 civil credits");
//        ret.add("total harga: 50 + 1000 = 1050 civil credits");
        model.addAttribute("logs", ret);

        return "pricing/home";
    }

}