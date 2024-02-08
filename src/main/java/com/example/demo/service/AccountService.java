package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Repository.AccountRepository;
import com.example.demo.entity.Account;
import com.example.demo.service.exception.RecsourceNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

	public class AccountService {
	    private final AccountRepository accountRepository;
//getall
	    public List<Account> getAllAccounts() {
	        return accountRepository.findAll();
	    }
//getone
	    public Account getAccountById(Integer id) {
 	      
	    return accountRepository
	    		.findById(id)
	    		.orElseThrow(()->new RecsourceNotFoundException("Account "+id+" not found"));
	    }
//post
	    public Account createAccount(Account account) {
	        return accountRepository.save(account);
	    }
//put	    
	    public Account putAccount (Integer id ,Account ac) {
	    	accountRepository
    		.findById(id)
    		.orElseThrow(()->new RecsourceNotFoundException("Account "+id+" not found"));
	    	ac.setId(id);
	    	return accountRepository.save(ac);
	    }
	    
//patchone
	    public Account updateAccount(Integer id, Account account) {
	        Account existingAccount = accountRepository
	        		.findById(id)
		    		.orElseThrow(()->new RecsourceNotFoundException("Account "+id+" not found"));
	        if (account.getName() != null) {
	            existingAccount.setName(account.getName());
	        }
	    	if(account.getBalance() != null) {

	         existingAccount.setBalance(account.getBalance());
 	        }
            return accountRepository.save(existingAccount);

	    }
//delete
	    public Account deleteAccount(Integer id) {
	     Account delettingAccount = accountRepository
	    		 .findById(id)
		    	 .orElseThrow(()->new RecsourceNotFoundException("Account "+id+" not found"));
	        accountRepository.deleteById(id);
	        return delettingAccount;
	    }
//filtering
//	    public List<Account> getAccountsByName(String name) {
//	        return accountRepository.findByName("ahmed");
//	    }
//	    
//	    public List<Account> getAccountsByBalance(double balance) {
//	        return accountRepository.findByBalance(balance);
//	    }
	    
	    	
	    }
	


