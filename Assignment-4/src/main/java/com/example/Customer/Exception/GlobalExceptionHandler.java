package com.example.Customer.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = {CustomerNotfoundException.class})
	 public ResponseEntity<Object> exception(CustomerNotfoundException exception){
		 return new ResponseEntity<>("Customer ot found", HttpStatus.NOT_FOUND);
	 }

}
