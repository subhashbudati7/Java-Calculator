package com.budati.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Calculator Application.
 * 
 * This Spring Boot application provides a comprehensive mathematical
 * calculation service with the following key characteristics:
 * 
 * - Supports multiple mathematical operations
 * - Implements a flexible strategy pattern for operations
 * - Enables complex, chained calculations
 * - Provides a RESTful API for mathematical computations
 * 
 * Design Principles:
 * - Extensibility: Easy to add new operation types
 * - Modularity: Clear separation of concerns
 * - Testability: Designed with unit and integration testing in mind
 * 
 * @author Budati
 * @version 1.0
 * @since 2025-03-28
 */
@SpringBootApplication
public class CalculatorApplication {

    /**
     * The main method that bootstraps and launches the Calculator application.
     * 
     * Responsibilities:
     * - Initializes the Spring Application Context
     * - Configures and starts all application components
     * - Sets up dependency injection and component scanning
     * 
     * @param args Optional command-line arguments for application configuration
     */
    public static void main(String[] args) {
        SpringApplication.run(CalculatorApplication.class, args);
    }
}