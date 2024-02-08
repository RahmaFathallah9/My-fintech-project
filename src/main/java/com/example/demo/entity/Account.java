package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class Account {
	
	    @Id
	    @GeneratedValue
	    private Integer id;
	    private String name;
	    private Double balance;

}
