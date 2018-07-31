package com.processing.processing_engine.transaction;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService implements ITransactionService {
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Override
	public List<Transaction> getAllTransactions() {
		List<Transaction> list = new ArrayList<>();
		transactionRepository.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	public void addTransaction(Transaction transaction) {
		transactionRepository.save(transaction);
	}
}
