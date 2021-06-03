package com.hotel.venator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hotel.venator.rest.CustomerRest;


@SpringBootApplication
public class VenatorApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(VenatorApplication.class, args);
	}
	
	@Autowired
	private CustomerRest customerRest;
	
	@Override
	  public void run(String... args) throws Exception {
		
		customerRest.addCustomers();
	  }


}
