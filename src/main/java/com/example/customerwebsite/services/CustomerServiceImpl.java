package com.example.customerwebsite.services;

import com.example.customerwebsite.model.Customer;
import com.example.customerwebsite.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


//  Once the SERVICE interface is defined, we can implement the methods
@Service
@RequiredArgsConstructor
//@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    final CustomerRepository customerRepository;

    // The findAll function gets all the customers by doing a SELECT query in the DB.
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // The save function uses an INSERT query DB.
    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // The findById function uses a SELECT query with a WHERE clause in the DB.
    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id)
                .orElse(null);
    }

    // The deleteById function deletes the customer by doing a DELETE in the DB.
    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);

    }

    // The saveAll function would do multiple INSERTS into the DB.
    @Override
    public List<Customer> saveAllCustomer(List<Customer> customerList) {
        return customerRepository.saveAll(customerList);
    }
}
