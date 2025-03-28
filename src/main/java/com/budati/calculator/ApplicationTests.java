package com.budati.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Temporary Application Test class for Spring Boot initialization.
 * 
 * This class serves as a placeholder for Spring Boot application context
 * testing and initialization. In a production scenario, this might be 
 * replaced with more comprehensive application startup tests.
 * 
 * @author Budati
 * @version 1.0
 * @since 2025-03-28
 */
@SpringBootApplication
public class ApplicationTests {

    /**
     * Starts the Spring Boot application for testing purposes.
     * 
     * This method allows manual running of the application context
     * and can be used for integration or manual testing scenarios.
     * 
     * @param args Command-line arguments passed to the application
     */
    public static void main(String[] args) {
        SpringApplication.run(ApplicationTests.class, args);
    }
}