package com.example.demo.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.service.exception.NotFoundBalanceException;

@ControllerAdvice
public class TransferExceptionHandler {
	@ExceptionHandler(NotFoundBalanceException.class)
	public ResponseEntity<ErrorRespose> handelResource(NotFoundBalanceException ex){
		ErrorRespose msg =new ErrorRespose();
		msg.setCode(-1);
		msg.setMessage(ex.getMessage());
		msg.setDetails( "more details");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
	}

}

 

