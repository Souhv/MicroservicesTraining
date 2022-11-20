package com.example.Customer;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Customer.Entity.Customer;
import com.example.Customer.Exception.CustomerNotfoundException;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

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

}
