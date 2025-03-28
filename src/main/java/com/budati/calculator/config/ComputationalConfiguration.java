package com.budati.calculator.config;

import com.budati.calculator.model.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Configuration class for registering mathematical operation strategies.
 * 
 * Centralizes the configuration of available computational strategies
 * through dependency injection and bean management.
 * 
 * @author Budati
 * @version 1.0
 * @since 2025-03-28
 */
@Configuration
public class ComputationalConfiguration {

    /**
     * Configures and registers mathematical operation strategies.
     * 
     * @param addStrategy Addition operation strategy
     * @param subtractStrategy Subtraction operation strategy
     * @param multiplyStrategy Multiplication operation strategy
     * @param divideStrategy Division operation strategy
     * @param powerStrategy Exponentiation operation strategy
     * @return Map of registered operation strategies
     */
    @Bean
    public Map<Operation, OperationStrategy> registerComputationalStrategies(
            Add addStrategy,
            Subtract subtractStrategy,
            Multiply multiplyStrategy,
            Divide divideStrategy,
            Power powerStrategy) {
        
        Map<Operation, OperationStrategy> strategyRegistry = new HashMap<>();
        strategyRegistry.put(Operation.ADD, addStrategy);
        strategyRegistry.put(Operation.SUBTRACT, subtractStrategy);
        strategyRegistry.put(Operation.MULTIPLY, multiplyStrategy);
        strategyRegistry.put(Operation.DIVIDE, divideStrategy);
        strategyRegistry.put(Operation.POWER, powerStrategy);
        
        return strategyRegistry;
    }
}