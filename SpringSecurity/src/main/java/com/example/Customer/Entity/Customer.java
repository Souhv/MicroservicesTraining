package com.example.Customer.Entity;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Data
@Entity
@Table
public class Customer{
	
	@Id
	@Column
	private int id;
	
	@Column
	@NotNull
	@Size(max = 10)
	private String customerName;
	
	@Column
	@JsonIgnore
	private String gender;
	
	@Column
	private String city;
}
