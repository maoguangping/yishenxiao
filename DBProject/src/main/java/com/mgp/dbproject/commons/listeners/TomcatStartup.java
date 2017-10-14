package com.mgp.dbproject.commons.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TomcatStartup implements ServletContextListener{

	Logger logger=LoggerFactory.getLogger(TomcatStartup.class);
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		//logger.info("Tomcat Shutdown up!");
		System.out.println("Tomcat Shutdown up!");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		//logger.info("Tomcat Start up!");
		System.out.println("Tomcat Start up!");
	}

}
