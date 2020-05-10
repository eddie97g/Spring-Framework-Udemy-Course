package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

import javassist.NotFoundException;

@RestController
@RequestMapping("/customers")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping()
	public List<Customer> getCustomers() {
		return this.customerService.getCustomers();
	}
	
	@GetMapping("/{id}")
	public Customer getCustomer(@PathVariable int id) {
		
		Customer customer = this.customerService.getCustomer(id);
		if (customer == null) {
			throw new CustomerNotFoundException("id: " + id + " was not found in the db");
		}
		return customer;
		
	}
	
	@PostMapping()
	public Customer addCustomer(@RequestBody Customer customer) {
		customer.setId(0);
		this.customerService.saveCustomer(customer);
		return customer;
	}
	
	@DeleteMapping("/{id}")
	public String deleteCustomer(@PathVariable int id) {
		
		Customer customer = this.customerService.getCustomer(id);
		
		if (customer == null) {
			throw new CustomerNotFoundException("id: " + id + " was not found in the db");
		}
		
		this.customerService.deleteCustomer(id);
		return "Customer with id: " + id + " has been deleted";
	}
	
	@PutMapping()
	public Customer updateCustomer(@RequestBody Customer customer) {
		this.customerService.saveCustomer(customer);
		return customer;
	}
}
