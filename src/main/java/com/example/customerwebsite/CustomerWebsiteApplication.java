package com.example.customerwebsite;

import com.example.customerwebsite.model.Customer;
import com.example.customerwebsite.model.Role;
import com.example.customerwebsite.model.User;
import com.example.customerwebsite.repositories.RoleRepository;
import com.example.customerwebsite.repositories.UserRepository;
import com.example.customerwebsite.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


//Bootstrapping file. The file that contains the man method
@Configuration
@SpringBootApplication
public class CustomerWebsiteApplication implements CommandLineRunner {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(CustomerWebsiteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


			// first approach
			// creation of the role
			Role roleAdmin = Role.builder().name("ADMIN").build();
			// check if it exists
			if (roleRepository.existsByName("ADMIN")) {
				// fetch it
				roleAdmin = roleRepository.findRoleByName("ADMIN");
			} else {
				roleAdmin = roleRepository.save(roleAdmin);
			}

			Role roleUser = Role.builder().name("USER").build();
			// check if it exists
			if (roleRepository.existsByName("USER")) {
				// fetch it
				roleUser = roleRepository.findRoleByName("USER");
			} else {
				roleUser = roleRepository.save(roleUser);
			}


			// second approach
			// flipped logic
			// fetch the role first
			User userAdmin = userRepository.findByUsername("UserAdmin");
			// if it is not there we create it
			if (userAdmin == null) {
				userAdmin = userRepository.save(User.builder()
						.username("UserAdmin")
						.password(passwordEncoder.encode("useradmin")) //encoding password
						.roles(Collections.singletonList(roleUser))
						.build());
			}

			User userUser = userRepository.findByUsername("UserUser");
			if (userUser == null) {
				userUser = userRepository.save(User.builder()
						.username("UserUser")
						.password(passwordEncoder.encode("useruser")) //encoding password
						.roles(Collections.singletonList(roleUser))
						.build());
			}
		}
	}



//	@Bean
//	public CommandLineRunner loadInitialData(CustomerService customerService) {
//		return (args) -> {
//			if (customerService.getAllCustomers().isEmpty()) {
//			List<Customer> customerList = customerService.saveAllCustomer(Arrays.asList(
//					Customer.builder().fullName("Customer 1").email("customer1@gmail.com").address("Customer Address One").age(30).build(),
//					Customer.builder().fullName("Customer 2").email("customer2@gmail.com").address("Customer Address Two").age(28).build(),
//					Customer.builder().fullName("Customer 3").email("customer3@gmail.com").address("Customer Address Three").age(32).build()));
//			System.out.println(customerList);
//			}
//		};
//	}

