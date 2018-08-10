package com.processing.processing_engine.transaction;

import com.processing.processing_engine.transaction.Transaction_POJO;
import java.util.List;

public interface Transaction_POJORepository {
	List<Transaction_POJO> list();
	int save(Transaction_POJO transaction);

}
