package org.jordi.jsfspring;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ManagedBean(name = "helloJsfBean")
@SessionScoped
public class HelloJsfBean implements Serializable {
	
	//@ManagedProperty(value = "#{helloSpringBean}")
	@Autowired
	private HelloSpringBean helloSpringBean;

	private Logger log = LoggerFactory.getLogger(HelloJsfBean.class);
	private String name;

	public String getName() {
		return name+helloSpringBean.getMessage();
	}
	public void setName(String name) {
		log.debug("insertando nombre"+name);
		this.name = name;
	}
}