package com.processing.processing_engine.transaction;

import java.util.List;

public interface ITransactionService {
	List<Transaction> getAllTransactions();
	void addTransaction(Transaction transaction);
}
