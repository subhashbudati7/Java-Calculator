package com.budati.calculator.model;

import org.springframework.stereotype.Component;

/**
 * Implementation of division operation strategy.
 * 
 * Provides a robust division operation with:
 * - Division by zero prevention
 * - Precise floating-point calculations
 * - Integration with calculator's operation framework
 * 
 * @author Budati
 * @version 1.0
 * @since 2025-03-28
 */
@Component
public class Divide implements OperationStrategy {
    
    /**
     * Performs division of two numbers with safety checks.
     * 
     * Implements critical error handling for division by zero.
     * Converts input to double for consistent calculation.
     * 
     * @param num1 Dividend (number to be divided)
     * @param num2 Divisor (number to divide by)
     * @return Result of the division operation
     * @throws IllegalArgumentException If attempting to divide by zero
     */
    @Override
    public Number apply(Number num1, Number num2) {
        // Explicitly check for division by zero to prevent runtime errors
        if (num2.doubleValue() == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return num1.doubleValue() / num2.doubleValue();
    }

    /**
     * Retrieves the corresponding Operation enum for this strategy.
     * 
     * @return The DIVIDE operation from the Operation enum
     */
    @Override
    public Operation getOperation() {
        return Operation.DIVIDE;
    }
}