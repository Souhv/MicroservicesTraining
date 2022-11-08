package com.example.Customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.Customer.Entity.Customer;

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
	
	@GetMapping(value = "/CustomerById/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable int id){
		System.out.println("ID"+id);
		Optional<Customer> Customerid = customerService.getCustomerByID(id);
		if(Customerid.isPresent()) {
			return new ResponseEntity<>(Customerid.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
