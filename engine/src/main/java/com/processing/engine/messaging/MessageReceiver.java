package com.processing.engine.messaging;

import javax.jms.JMSException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import com.processing.engine.model.TransactionClass;

@Component
public class MessageReceiver {
	static final Logger LOG = LoggerFactory.getLogger(MessageReceiver.class);
	
	public void receiveMessage(final Message<TransactionClass> message) throws JMSException {
		LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		MessageHeaders headers =  message.getHeaders();
		LOG.info("Application : headers received : {}", headers);
		
		TransactionClass transaction = message.getPayload();
		LOG.info("Application : response received : {}", transaction); 
		LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
}
