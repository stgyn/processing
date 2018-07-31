package com.processing.processing_engine;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.processing.processing_engine.configutation.AppConfiguration;

@ComponentScan
public class ApplicationInitializer implements WebApplicationInitializer {
	public void onStartup(ServletContext container) throws ServletException {
		System.out.println("1 !!!!!!!!!!!!!!");
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(AppConfiguration.class);
		System.out.println("2 !!!!!!!!!!!!!!");
        ctx.setServletContext(container);
        ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
		System.out.println("3 !!!!!!!!!!!!!!");
    }
}
