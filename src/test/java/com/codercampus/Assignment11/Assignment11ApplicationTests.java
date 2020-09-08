package com.codercampus.Assignment11;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;

class Assignment11ApplicationTests {
	
	TransactionRepository transactionRepository = new TransactionRepository();
	
	@Test
	void should_return_null_if_transaction_id_bigger_than_100() {
		assertNull(transactionRepository.findById(101L));
	}
	
	@Test
	void should_return_transactions_list_of_length_100() {
		assertEquals(100, transactionRepository.findAll().size());
	}
	
	@Test
	void should_match_object_at_index_0_with_object_with_id_1 () {
		assertEquals(transactionRepository.findAll().get(0), transactionRepository.findById(1L));
	}
	
	@Test
	void should_ascendingly_arrange_transactions_by_date() {
		Transaction transactionNewest = new Transaction();
		transactionNewest.setDate(LocalDateTime.now());
		Transaction transactionOldest = new Transaction();
		transactionOldest.setDate(LocalDateTime.of(1969, 7, 20, 2, 56));
		
		List<Transaction> transactions = new ArrayList<>(2);
		transactions.add(transactionNewest);
		transactions.add(transactionOldest);
		
		Collections.sort(transactions);
		
		assertEquals(transactionOldest, transactions.get(0));
		assertEquals(transactionNewest, transactions.get(1));
	}
}
