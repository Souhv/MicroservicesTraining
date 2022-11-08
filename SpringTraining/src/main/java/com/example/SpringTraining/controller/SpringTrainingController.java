package com.example.SpringTraining.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.SpringTraining.entities.EmployeeDetails;

@RestController
@RequestMapping("/Hello")
public class SpringTrainingController {
	
	@GetMapping("/getUserName")
	public String getUserName(@RequestParam(value="userName", required=false) String userName) {
		return "Happy Learning "+userName;
	}
	
	@GetMapping("/getEmployeeDetails")
	public EmployeeDetails getEmployeeDetails() {
		EmployeeDetails obj = new EmployeeDetails();
		obj.setName("HVS");
		obj.setId("123");
		obj.setDesignation("AST");
		obj.setLocation("Blr");
		return obj;
	}

}
