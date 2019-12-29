package org.jordi;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelStarted {

    public void createCamelPipeline() throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(
            new RouteBuilder() {
            // Configure filters and routes
                public void configure() throws Exception {
                    from("file:///home/vagrant/in")
                .to("file:///home/vagrant/out");
            }
            });
        System.out.println("starting camel");    
        context.setTracing(true);
        context.start();
        Thread.sleep(2000);
        context.stop();
    }

}