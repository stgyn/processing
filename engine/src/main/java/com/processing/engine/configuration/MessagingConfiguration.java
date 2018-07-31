package com.processing.engine.configuration;

import java.util.Arrays;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class MessagingConfiguration {
	private static final String DEFAULT_BROKER_URL = "tcp://localhost:61616";
	private static final String TRANSACTION_QUEUE = "transaction-queue";
	private static final String BROKER_USERNAME = "admin";
	private static final String BROKER_PASSWORD = "admin";

	@Bean
	public ActiveMQConnectionFactory connectionFactory(){
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);
		connectionFactory.setPassword(BROKER_USERNAME);
		connectionFactory.setUserName(BROKER_PASSWORD);
		connectionFactory.setTrustedPackages(Arrays.asList("com.processing.engine","java.util"));
		return connectionFactory;
	}
	
	@Bean
	public JmsTemplate jmsTemplate(){
		JmsTemplate template = new JmsTemplate();
		template.setConnectionFactory(connectionFactory());
		template.setDefaultDestinationName(TRANSACTION_QUEUE);
		return template;
	}
}
