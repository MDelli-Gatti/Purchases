package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by michaeldelli-gatti on 6/22/16.
 */
@Controller
public class PurchasesController {

    @Autowired
    PurchaseRepository purchases;

    @Autowired
    CustomerRepository customers;

    @PostConstruct
    public void init() throws FileNotFoundException {
        if (customers.count() == 0) {
            File f = new File("customers.csv");
            Scanner scanner = new Scanner(f);
            scanner.nextLine();
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] columns = line.split(",");
                Customer customer = new Customer(columns[0], columns[1]);
                customers.save(customer);
            }
        }
        if (purchases.count() == 0){
            File f = new File("purchases.csv");
            Scanner scanner = new Scanner(f);
            scanner.nextLine();
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                String [] columns = line.split(",");
                Customer c = customers.findOne(Integer.valueOf(columns[0]));
                Purchase purchase = new Purchase(columns[1], columns[2], columns[3], columns[4], c);
                purchases.save(purchase);
            }
        }
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model){
        Iterable<Purchase> p = purchases.findAll();
        model.addAttribute("purchases", p);
        return "home";
    }
}
