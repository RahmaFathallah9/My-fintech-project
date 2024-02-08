package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Repository.TransactionRepository;
import com.example.demo.entity.Transaction;
import com.example.demo.service.exception.RecsourceNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final  TransactionRepository  transactionRepository;
//getall
    public List<Transaction> getAllTranaction() {
        return transactionRepository.findAll();
    }
//getone
    public Transaction getTransactionById(Integer id) {
        return transactionRepository
        		.findById(id)
	    		.orElseThrow(()->new RecsourceNotFoundException("Account "+id+" not found"));
    }

}
