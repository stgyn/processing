package com.processing.processing_engine.jms;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.processing.processing_engine.transaction.Transaction;

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

	@Override
	public void onMessage(Message message) {
		ActiveMQTextMessage textMessage = (ActiveMQTextMessage) message;
		try {
			System.out.println("Processing task " + textMessage.getText() + " " + message.getJMSDestination());
			Gson gson = new Gson();
			Transaction transaction = gson.fromJson(textMessage.getText(), Transaction.class);	
			System.out.println(transaction.GetAccount());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}

