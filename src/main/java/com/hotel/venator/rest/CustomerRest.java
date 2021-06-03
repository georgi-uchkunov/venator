package com.hotel.venator.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.venator.models.Customer;
import com.hotel.venator.repos.CustomerRepository;

@RestController
public class CustomerRest{
	
	private CustomerRepository repository;
	
	@Autowired
	public CustomerRest(CustomerRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping("/addExampleCustomers")
    public ResponseEntity<Customer> addCustomers() {

		repository.save(new Customer("Alice", "Smith"));
	    repository.save(new Customer("Bob", "Smith"));
	    return null;
		

    }
}