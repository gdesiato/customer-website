package com.example.customerwebsite.controller;

import com.example.customerwebsite.model.Customer;
import com.example.customerwebsite.model.User;
import com.example.customerwebsite.services.CustomerService;
import com.example.customerwebsite.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

// We want to create some ENDPOINTS or some SERVLETS which are going to be used by third parties (the outside world)
// to interact with this application.
@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private UserService userService;

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

    @GetMapping("/customer-list")
    public String showListOfCustomer(){
        if (customerService.getAllCustomers().isEmpty()) {
            List<Customer> customerList = customerService.saveAllCustomer(Arrays.asList(
                    Customer.builder()
                            .fullName("Customer 1")
                            .email("customer1@gmail.com")
                            .address("Customer Address One")
                            .age(30).build()));
        }
        return "customer-list";
    }

    @PostMapping(value = "/save")
    // As the Model is received back from the view, @ModelAttribute
    // creates a Customer based on the object you collected from
    // the HTML page above
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    // The path variable "id" is used to pull a customer from the database
    public ModelAndView showEditCustomerPage(@PathVariable(name = "id") Long id) {
        // Since the previous methods use Model, this one uses ModelAndView
        // to get some experience using both. Model is more common these days,
        // but ModelAndView accomplishes the same thing and can be useful in
        // certain circumstances. The view name is passed to the constructor.
        ModelAndView mav = new ModelAndView("edit-customer");
        Customer customer = customerService.getCustomer(id);
        mav.addObject("customer", customer);
        return mav;
    }

    @PostMapping ("/update/{id}")
    public String updateCustomer(@PathVariable(name = "id") Long id, @ModelAttribute("customer") Customer customer, Model model) {
        if (!id.equals(customer.getId())) {
            model.addAttribute("message",
                    "Cannot update, customer id " + customer.getId()
                            + " doesn't match id to be updated: " + id + ".");
            return "error-page";
        }
        customerService.saveCustomer(customer);
        return "redirect:/";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    // Create the POST /register method. In this method,
    // you will take in a user object then utilize your UserService to verify and persist it
    // (with an encoded password!) to the database.
//    @PostMapping("/register")
//    public String registerUserAccount(){
//
//        return "";
//    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        userService.save(user);
        return "redirect:/login";
    }

    @RequestMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable(name = "id") Long id) {
        customerService.deleteCustomer(id);
        return "redirect:/";
    }

}
