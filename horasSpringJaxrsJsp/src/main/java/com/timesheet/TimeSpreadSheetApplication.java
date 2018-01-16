package com.timesheet;

import javax.servlet.ServletException;

import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
//@Configuration
//@EnableWebMvc

public class TimeSpreadSheetApplication  extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(TimeSpreadSheetApplication.class, args);
	}
	
	@Bean
	public ServletRegistrationBean jerseyServlet() throws ServletException {
	    ServletContainer servlet = new ServletContainer();
	    ServletRegistrationBean registration = new ServletRegistrationBean(servlet, "/rest/*");
	    registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyConfig.class.getName());
	    return registration;
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TimeSpreadSheetApplication.class);
	}


}
