package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Account;
import com.example.demo.service.AccountService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountController {
	    private final AccountService accountService ;

	    @GetMapping
	    public ResponseEntity<List<Account>> getAllAccounts() {
	   
	    	return  ResponseEntity
	    			.status(HttpStatus.ACCEPTED)
	    			.body(accountService.getAllAccounts());
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity <Account> getAccountById(@PathVariable("id") Integer id) {
	        return ResponseEntity
	        		.status(HttpStatus.OK)
	    			.body(accountService.getAccountById(id));
	    }

	    @PostMapping
	    public ResponseEntity< Account> createAccount(@RequestBody Account account) {
	    	 return ResponseEntity
		        		.ok(accountService.createAccount(account));
	       
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Account> updateAccount(@RequestBody Account account,@PathVariable("id") Integer id) {
	    	return ResponseEntity
	        		.status(HttpStatus.OK)
	    			.body(accountService.updateAccount(id, account));


	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Account>deleteAccount(@PathVariable("id") Integer id) {
	    	
	    	return ResponseEntity
	        		.status(HttpStatus.OK)
	    			.body(accountService.deleteAccount(id));

 	        
	    }
	    @PatchMapping("/{id}")
	    public ResponseEntity<Account> patchAccount(@RequestBody Account account,@PathVariable("id") Integer id) {
	    	return ResponseEntity
	        		.status(HttpStatus.OK)
	    			.body(accountService.updateAccount(id, account));

	        
	    }
//	     
	}

