package com.processing.processing_engine.configutation;

import java.util.Arrays;

import javax.sql.DataSource;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListenerConfigurer;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerEndpointRegistrar;
import org.springframework.jms.config.SimpleJmsListenerEndpoint;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.core.env.Environment;

import com.processing.processing_engine.jms.TransactionListener;

@Configuration
@EnableJms
@ComponentScan(basePackages = "com.processing")
@EnableTransactionManagement
@PropertySource("classpath:jms.properties")
@Import({DataBaseConfig.class})
public class AppConfiguration implements JmsListenerConfigurer{
	@Autowired
	private Environment env;
	
	@Autowired
	private TransactionListener listener;

	@Bean
	public ActiveMQConnectionFactory connectionFactory(){
		System.out.println("!!!!!!!!!!!!!! "+env.getProperty("BROKER_URL"));
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL(env.getProperty("BROKER_URL"));
		connectionFactory.setUserName(env.getProperty("USER"));
		connectionFactory.setPassword(env.getProperty("PASSWD"));
		connectionFactory.setTrustedPackages(Arrays.asList("com.processing.processing_engine","java.util"));
		return connectionFactory;
	}
	
	@Bean
	public JmsTemplate jmsTemplate(){
	    JmsTemplate template = new JmsTemplate();
	    template.setConnectionFactory(connectionFactory());
	    return template;
	}

	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
	    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
	    factory.setConnectionFactory(connectionFactory());
	    factory.setConcurrency("1-1");
	    return factory;
	}

	@Override
	public void configureJmsListeners(JmsListenerEndpointRegistrar registrar) {
		for (int i = 1; i <= Integer.parseInt(env.getProperty("COUNT_QUEUES")); i++) {
			SimpleJmsListenerEndpoint endpoint = new SimpleJmsListenerEndpoint();
			endpoint.setId("str"+"_"+i);
			endpoint.setDestination("transaction-queue_"+i);
			endpoint.setMessageListener(listener);
			registrar.registerEndpoint(endpoint);
		}
	}
}
