package org.jordi.application.config;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Singleton;

@RequestScoped
public class Configuration {


    @Produces
    @Property("")
    String  valueofProperty(InjectionPoint injectionPoint){
        System.out.println("en el Produces");
        Property property = injectionPoint.getAnnotated().getAnnotation(Property.class);
        return "clave mas "+ property.value();
           }
}