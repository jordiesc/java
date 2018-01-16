package com.timesheet;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.timesheet.rs.HoraController;
import com.timesheet.rs.ProjectController;
import com.timesheet.rs.TaskController;
import com.timesheet.rs.UserController;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
@Component
@ApplicationPath("/rest")
public class JerseyConfig extends ResourceConfig {
	
	public JerseyConfig() {
		
		        register(ProjectController.class);
		        register(UserController.class);
		        register(TaskController.class);
		        register(HoraController.class);
		        
		        //adding swagger
		        register(ApiListingResource.class);
		        register(SwaggerSerializers.class);
		        configureSwagger();
		        //enable cors
		        register(CORSResponseFilter.class);
		        
		        
		    }
	private void configureSwagger() {
		register(ApiListingResource.class);
		BeanConfig beanConfig = new BeanConfig();

		beanConfig.setBasePath("/rest");
		beanConfig.setTitle("swagger, spring, jax-rs API Sample");
		beanConfig.setPrettyPrint(true);
		
		beanConfig.setResourcePackage("com.timesheet.rs");
		beanConfig.setScan();
}
	

}
