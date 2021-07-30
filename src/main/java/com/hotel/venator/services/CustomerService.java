package com.hotel.venator.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotel.venator.models.Customer;
import com.hotel.venator.repos.CustomerRepository;

@Service
public class CustomerService {
	
private CustomerRepository repository;
	
	@Autowired
	public CustomerService(CustomerRepository repository) {
		this.repository = repository;
	}
	
	 public ResponseEntity<Customer> addCustomers() {

			repository.save(new Customer("Alice", "Smith"));
		    repository.save(new Customer("Bob", "Smith"));
		    return null;
			

	    }
}