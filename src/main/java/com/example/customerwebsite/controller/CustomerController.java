package com.example.customerwebsite.controller;

import com.example.customerwebsite.model.Customer;
import com.example.customerwebsite.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //call the service to retrieve all the customers
    @GetMapping("/")
    public String viewHomePage(Model model){
        final List<Customer> customerList = customerService.getAllCustomers();
    // Once the customers are retrieved, you can store them in model and return it  to the view
    model.addAttribute("customerList", customerList);
    return "index";
    }

    @GetMapping("/new")
    public String showNewCustomerPage(Model model) {
        // Here a new (empty) Customer is created and then sent to the view
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "new-customer";
    }

}
