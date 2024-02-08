package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Transaction {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private Integer toAccount;
	private Integer fromAccount;
	private Double amount;

	

}
