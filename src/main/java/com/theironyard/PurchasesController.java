package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by michaeldelli-gatti on 6/22/16.
 */
@Controller
public class PurchasesController {
    @Autowired
    PurchaseRepository purchases;

    @Autowired
    CustomerRepository customers;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model){

        return "home";
    }
}
