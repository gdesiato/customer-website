package com.example.customerwebsite.services;

import com.example.customerwebsite.model.Customer;
import java.util.List;

// Here is where we insert the functionalities (methods) that we need
public interface CustomerService {

    List<Customer> getAllCustomers();
    Customer saveCustomer (Customer customer);
    Customer getCustomer(Long id);
    void deleteCustomer(Long id);
    List<Customer> saveAllCustomer(List<Customer> customerList);
}
