package com.processing.processing_engine.jms;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.processing.processing_engine.transaction.Transaction;
import com.processing.processing_engine.transaction.TransactionImpl;

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
	private TransactionImpl transactionImpl; 
	
	@Override
	public void onMessage(Message message) {
		ActiveMQTextMessage textMessage = (ActiveMQTextMessage) message;
		try {
			System.out.println("Processing task " + textMessage.getText() + " " + message.getJMSDestination());
			Gson gson = new Gson();
			Transaction transaction = gson.fromJson(textMessage.getText(), Transaction.class);	
			int tID = transactionImpl.save(transaction);
			System.out.println("tID " + tID);
			System.out.println(transaction.GetAccount());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}

