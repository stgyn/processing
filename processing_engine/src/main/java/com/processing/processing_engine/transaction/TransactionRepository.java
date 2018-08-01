package com.processing.processing_engine.transaction;

import java.util.List;
import com.processing.processing_engine.transaction.Transaction;

public interface TransactionRepository {
	List<Transaction> list();
	int save(Transaction transaction);
}
