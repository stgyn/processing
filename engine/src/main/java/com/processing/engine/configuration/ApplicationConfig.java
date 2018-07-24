package com.processing.engine.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.processing.engine")
@Import({MessagingConfiguration.class, MessagingListnerConfiguration.class})
public class ApplicationConfig {

}
