package com.example.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Customer.Entity.Customer;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Integer>{

}
