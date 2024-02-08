package com.example.demo.controller.advice;
import lombok.Data;

@Data
//@Entity
public class ErrorRespose {
	private Integer code;
	private String message;
	private String details;

	

}
