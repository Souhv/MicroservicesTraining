package com.example.Customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Customer.Exception.CustomerNotfoundException;
import com.example.Customer.Entity.Customer;

import javax.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value = "/getCustomer")
	public ResponseEntity<List<Customer>> getCustomer(){ 
		List<Customer> customerList = customerService.getAllCustomer();
		return new ResponseEntity<>(customerList, HttpStatus.OK);
	}
	
	@GetMapping(value = "getById/{id}")
	public ResponseEntity<Customer> getCustomerByID(@PathVariable int id) {
		Customer cust = customerService.getCustomerByID(id);
		if(null != cust) {
			
			return new ResponseEntity<>(cust, HttpStatus.OK);
			
		}else {
			
			throw new CustomerNotfoundException();
		}
	}
	
	@PostMapping(value = "/create")
	public ResponseEntity<Object> createCustomer(@Valid @RequestBody Customer cust){
		return customerService.createCustomer(cust);
	}

}
