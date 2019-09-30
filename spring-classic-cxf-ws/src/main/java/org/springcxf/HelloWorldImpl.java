package org.springcxf;

import javax.jws.WebService;

@WebService(endpointInterface = "org.springcxf.HelloWorld")
public class HelloWorldImpl implements HelloWorld {
 
    public String sayHi(String text) {
        System.out.println("sayHi called");
        return "Hello " + text;
    }
}
