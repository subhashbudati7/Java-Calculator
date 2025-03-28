package com.budati.calculator.model;

import org.springframework.stereotype.Component;

/**
 * Implementation of addition operation strategy.
 * 
 * Provides a concrete strategy for performing addition 
 * within the calculator's flexible operation framework.
 * 
 * Key Characteristics:
 * - Converts input numbers to double for precise calculation
 * - Implements the OperationStrategy interface
 * - Spring-managed component for dependency injection
 * 
 * @author Budati
 * @version 1.0
 * @since 2025-03-28
 */
@Component
public class Add implements OperationStrategy {
    
    /**
     * Performs addition of two numbers.
     * 
     * Converts input numbers to double to ensure 
     * consistent and precise calculation across 
     * different numeric types.
     * 
     * @param num1 First number in the addition
     * @param num2 Second number in the addition
     * @return Result of the addition operation
     */
    @Override
    public Number apply(Number num1, Number num2) {
        return num1.doubleValue() + num2.doubleValue();
    }
    
    /**
     * Retrieves the corresponding Operation enum for this strategy.
     * 
     * @return The ADD operation from the Operation enum
     */
    @Override
    public Operation getOperation() {
        return Operation.ADD;
    }
}