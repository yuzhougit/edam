package com.citrix.example;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.kohsuke.stapler.Stapler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebAppMain implements ServletContextListener {
    
    private static Logger logger = LoggerFactory.getLogger(WebAppMain.class);

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {

        logger.info("Context destroyed");
        
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {

        logger.info("Context initialized: {}", event.getSource());
        
        Stapler.setRoot(event, BookStore.theStore);
    }

}
