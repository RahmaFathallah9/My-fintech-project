package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repository.AccountRepository;
import com.example.demo.Repository.TransactionRepository;
import com.example.demo.entity.Account;
import com.example.demo.entity.Transaction;
import com.example.demo.service.exception.NotFoundBalanceException;
import com.example.demo.service.exception.RecsourceNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class TransferService {
	
	private final AccountRepository accountRepository;
	private final TransactionRepository transactionRepository;
	
	public Transaction transfer (Transaction transaction) {
		
		 
		Account fromAccount= accountRepository
				.findById(transaction.getFromAccount())
				.orElseThrow(()->new RecsourceNotFoundException ("Account "+transaction.getFromAccount()+" not found"));
		
		Account toAcc= accountRepository
				.findById(transaction.getToAccount())
			     .orElseThrow(()->new RecsourceNotFoundException ("Account "+transaction.getToAccount()+" not found"));
        if(toAcc.getBalance()<transaction.getAmount()) {
    	     throw new NotFoundBalanceException("not allowed");
    }
		
		fromAccount.setBalance(fromAccount.getBalance()- transaction.getAmount());
		toAcc.setBalance(toAcc.getBalance() + transaction.getAmount());
//		
//		System.out.println(fromAcc);
//		System.out.println(toAcc);
		accountRepository.save(fromAccount);
		accountRepository.save(toAcc);
//		
		return transactionRepository.save(transaction);
	


	}

	

}
