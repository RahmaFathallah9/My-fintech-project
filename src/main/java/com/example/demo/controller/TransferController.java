package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Transaction;
import com.example.demo.service.TransferService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transfer")


public class TransferController {
     public final TransferService  transferService;
     
     @PostMapping
	    public Transaction postTransfer(@RequestBody Transaction transaction ) {
    	 
    	 	System.out.println(transaction);
	    	 return transferService.transfer(transaction) ;
	    }
     
}
