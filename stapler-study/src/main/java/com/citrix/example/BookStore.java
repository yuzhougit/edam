package com.citrix.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookStore {
    private static Logger logger = LoggerFactory.getLogger(BookStore.class);
    
    public static BookStore theStore = new BookStore();
    
    private BookStore() {
        
        logger.info("Book store is created");
    }

}
