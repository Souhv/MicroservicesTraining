package com.example.Customer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Customer.Entity.Customer;
import com.example.Customer.Exception.CustomerNotfoundException;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	public List<Customer> getAllCustomer(){
		return customerDAO.findAll();
	}
	
	public Customer getCustomerByID(int id){
		try {
			return customerDAO.findById(id).get();
		}catch (Exception e) {
			throw new CustomerNotfoundException();
		}
		
	}
	
	public ResponseEntity<Object> createCustomer(Customer cust) {
		Optional<Customer> customer = customerDAO.findById(cust.getId());
		if(!customer.isPresent()) {
			customerDAO.save(cust);
			return new ResponseEntity<Object>("New Customer Added Successfully!",HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Customer Already Exsists!",HttpStatus.BAD_REQUEST);
	}

}
