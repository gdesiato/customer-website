package com.example.customerwebsite;

import com.example.customerwebsite.model.Customer;
import com.example.customerwebsite.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

//Bootstrapping file. The file that contains the man method
@Configuration
@SpringBootApplication
public class CustomerWebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerWebsiteApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadInitialData(CustomerService customerService) {
		return (args) -> {
			if (customerService.getAllCustomers().isEmpty()) {
			List<Customer> customerList = customerService.saveAllCustomer(Arrays.asList(
					Customer.builder().fullName("Customer 1").email("customer1@gmail.com").address("Customer Address One").age(30).build(),
					Customer.builder().fullName("Customer 2").email("customer2@gmail.com").address("Customer Address Two").age(28).build(),
					Customer.builder().fullName("Customer 3").email("customer3@gmail.com").address("Customer Address Three").age(32).build()));
			System.out.println(customerList);
			}
		};
	}
}
