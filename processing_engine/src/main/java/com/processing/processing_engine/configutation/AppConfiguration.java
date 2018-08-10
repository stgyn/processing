package com.processing.processing_engine.configutation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJms
@ComponentScan(basePackages = "com.processing")
@EnableTransactionManagement
@PropertySource("classpath:jms.properties")
@Import({DataBaseConfig.class, MQJmsConfig.class})
public class AppConfiguration {
}
