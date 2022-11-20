package com.example.Customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Customer.Entity.Customer;
import com.example.Customer.Exception.CustomerNotfoundException;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/allCustomer")
	public List<Customer> getAllCustomers(){ 
		return customerService.getAllCustomer();
	}
	
	@GetMapping("/customer/getById/{id}")
	public EntityModel<Customer> getCustomerByID(@PathVariable int id) {
		Customer c = customerService.getCustomerByID(id);
		if(null != c) {
			EntityModel<Customer> customer = EntityModel.of(c); 
			WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllCustomers());
			customer.add(link.withRel("all-customers"));
			return customer;
		}else {
			throw new CustomerNotfoundException();
		}
	}

}
