package com.hotel.venator.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.venator.models.Customer;
import com.hotel.venator.services.CustomerService;

@RestController
public class CustomerRest{
	
	private CustomerService customerService;
	
	@Autowired
	public CustomerRest(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@PostMapping("/addExampleCustomers")
    public ResponseEntity<Customer> addCustomers() {
		return customerService.addCustomers();
    }
}