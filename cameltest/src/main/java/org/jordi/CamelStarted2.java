package org.jordi;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelStarted2 {

    public void createCamelPipeline() throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(
            new RouteBuilder() {
            // Configure filters and routes
                public void configure() throws Exception {
                    from("direct:start")                    .process(
                        new Processor(){
                        
                            @Override
                            public void process(Exchange exchange) throws Exception {
                                System.out.println(" EL MENSAJE AL EMTAR");
                                System.out.println(exchange.getIn().getBody().toString());
                                exchange.getMessage().setBody("camabienado la salida");       
                            }
                        }
                    ).to("file:///home/vagrant/out?fileName=salisa.txt");

            }
            });
            
        System.out.println("starting camel");    
        context.setTracing(true);
        context.start();
    
        context.createProducerTemplate().sendBody("direct:start","me cago en la leche");
        Thread.sleep(2000);
        context.stop();
    }

}