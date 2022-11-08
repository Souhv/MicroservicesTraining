package com.example.Customer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Customer.Entity.Customer;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	public List<Customer> getAllCustomer(){
		return customerDAO.findAll();
	}
	
	public Optional<Customer> getCustomerByID(int id){
		return customerDAO.findById(id);
	}

}
