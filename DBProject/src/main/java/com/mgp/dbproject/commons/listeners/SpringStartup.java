package com.mgp.dbproject.commons.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class SpringStartup implements ApplicationListener<ContextRefreshedEvent> {
    
	Logger logger=LoggerFactory.getLogger(SpringStartup.class);
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
	  if(contextRefreshedEvent.getApplicationContext().getDisplayName().equals("Root WebApplicationContext")){
		  //logger.info("Spring Start up！");
		  System.out.println("Spring Start up！");
	  }
	}

}
