package com.processing.processing_engine.transaction;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.processing.processing_engine.transaction.ITransactionService;;

@RestController
@RequestMapping("transaction")
public class TransactionController {
	@Autowired
	private ITransactionService transactionService;
	
	@GetMapping(value="transactions")
	public ResponseEntity<List<TransactionInfo>> getAllTransactions() { 
		List<TransactionInfo> responseTransactionList = new ArrayList<>();
		List<Transaction> transactionList = transactionService.getAllTransactions();
		for (int i = 0; i < transactionList.size(); i++) {
			TransactionInfo ti = new TransactionInfo();
			BeanUtils.copyProperties(transactionList.get(i), ti);
			responseTransactionList.add(ti);
		}
		return new ResponseEntity<List<TransactionInfo>>(responseTransactionList, HttpStatus.OK);
	}
	
	@PostMapping(value= "transaction")
	public ResponseEntity<Void> addTransaction(@RequestBody TransactionInfo transactionInfo, UriComponentsBuilder builder) {
		Transaction transaction = new Transaction();
		BeanUtils.copyProperties(transactionInfo, transaction);
		transactionService.addTransaction(transaction);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/transaction/{id}").buildAndExpand(transaction.getID()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
}
