package com.codercampus.Assignment11.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	public Transaction findById(Long transactionId) {
		return transactionRepository.findById(transactionId);
	}
	
	public List<Transaction> findAll() {
		return transactionRepository.findAll();
	}
	
	// we sort the list by applying Comparable and overriding 
	// 'compareTo()' in 'Transaction' object
	public void sortByAscendingDate(List<Transaction> transactions) {
		Collections.sort(transactions);
	}
}