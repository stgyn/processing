package com.processing.processing_engine.jms;

import org.springframework.stereotype.Component;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.processing.processing_engine.transaction.Transaction;
import com.processing.processing_engine.transaction.TransactionImpl;
import com.processing.processing_engine.transaction.TransactionRepository;
import com.processing.processing_engine.transaction.Transaction_POJO;

import java.lang.reflect.Type;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;

@Component
public class TransactionListener implements MessageListener {
	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private TransactionRepository transactionService; 
	
	@Override
	public void onMessage(Message message) {
		ActiveMQTextMessage textMessage = (ActiveMQTextMessage) message;
		try {
			System.out.println("Processing task " + textMessage.getText() + " " + message.getJMSDestination());
			GsonBuilder builder = new GsonBuilder();
			builder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
			Gson gson = builder.create();
			Transaction_POJO transaction_POJO = gson.fromJson(textMessage.getText(), Transaction_POJO.class);
			transaction_POJO.PrintTransactionPOJO();
			//Gson gson = new Gson();
			//Transaction_POJO transaction_POJO = gson.fromJson(textMessage.getText(), Transaction_POJO.class);
			//System.out.println(gson.toJson(transaction_POJO));
			
			//transaction_POJO.PrintTransactionPOJO();
			//Type stringStringMap = new TypeToken<Map<String, String>>(){}.getType();
			//Map<String,String> map = gson.fromJson(textMessage.getText(), stringStringMap);
			//System.out.println(map.get("transaction_uuid"));
			//HashMap<String, LinkedTreeMap> trn = gson.fromJson(textMessage.getText(), HashMap.class);
			//Transaction transaction = new Transaction(trn.get("transaction_uuid").toString(), trn.get("transaction_type").toString(), Integer.parseInt(trn.get("transaction_account").toString()), "", Double.parseDouble(trn.get("transaction_amount").toString()), textMessage.getText(), trn.get("transaction_addinfo").toString()); 
			//System.out.println(trn.get("transaction_uuid"));
			//System.out.println(trn.get("transaction_addinfo"));
			//Transaction transaction = gson.fromJson(textMessage.getText(), Transaction.class);
			//transaction.setContent(textMessage.getText());
			//System.out.println(transaction.getUUID());
			//int tID = transactionService.save(transaction);
			//System.out.println("tID " + tID);
			//System.out.println(transaction.GetAccount());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}

