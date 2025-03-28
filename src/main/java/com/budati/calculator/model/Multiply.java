package com.budati.calculator.model;

import org.springframework.stereotype.Component;

/**
 * Implementation of multiplication operation strategy.
 * 
 * Provides a concrete strategy for performing multiplication
 * within the calculator's flexible operation framework.
 * 
 * Design Principles:
 * - Supports multiple numeric types
 * - Ensures consistent calculation through double conversion
 * - Seamlessly integrates with operation selection mechanism
 * 
 * @author Budati
 * @version 1.0
 * @since 2025-03-28
 */
@Component
public class Multiply implements OperationStrategy {
    
    /**
     * Performs multiplication of two numbers.
     * 
     * Converts input numbers to double to ensure 
     * consistent calculation across different numeric types.
     * 
     * @param num1 First number in the multiplication
     * @param num2 Second number in the multiplication
     * @return Result of the multiplication operation
     */
    @Override
    public Number apply(Number num1, Number num2) {
        return num1.doubleValue() * num2.doubleValue();
    }

    /**
     * Retrieves the corresponding Operation enum for this strategy.
     * 
     * @return The MULTIPLY operation from the Operation enum
     */
    @Override
    public Operation getOperation() {
        return Operation.MULTIPLY;
    }
}