package com.example.demo.controller;



import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Transaction;
import com.example.demo.service.TransactionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionController {
    private final  TransactionService  transactionService ;

	 @GetMapping
	    public ResponseEntity<List<Transaction>> getAllTranaction1() {
	
	    	return ResponseEntity
	    			.status(HttpStatus.ACCEPTED)
	    			.body(transactionService .getAllTranaction());
	    }
	    @GetMapping("/{id}")
	    public ResponseEntity<Transaction> getTransactionById1(@PathVariable("id") Integer id) {
	        return ResponseEntity
	        		.status(HttpStatus.OK)
	    			.body(transactionService.getTransactionById(id));
	    }


}
