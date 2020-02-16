package org.jordi.jsfspring;

import javax.faces.bean.ManagedBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ManagedBean(name = "helloWorld", eager = true)
public class HelloWorld {
   
	Logger logger = LoggerFactory.getLogger(HelloWorld.class);
	
   public HelloWorld() {
	  logger.info("helloworkd started"); 
      System.out.println("HelloWorld started!");
   }
	
   public String getMessage() {
      return "Hello World!";
   }
}