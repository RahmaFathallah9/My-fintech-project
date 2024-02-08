package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Account;

public interface AccountRepository extends JpaRepository<Account,Integer> {
//	 List<Account> findByName(String name);
//	    List<Account> findByBalance(double balance);

}
