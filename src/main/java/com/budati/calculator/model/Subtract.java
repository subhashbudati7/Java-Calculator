package com.budati.calculator.model;

import org.springframework.stereotype.Component;

/**
 * Implementation of subtraction operation strategy.
 * 
 * Provides a concrete strategy for performing subtraction
 * within the calculator's flexible operation framework.
 * 
 * Design Characteristics:
 * - Supports multiple numeric input types
 * - Ensures consistent calculation through double conversion
 * - Seamlessly integrates with operation selection mechanism
 * 
 * @author Budati
 * @version 1.0
 * @since 2025-03-28
 */
@Component
public class Subtract implements OperationStrategy {
    
    /**
     * Performs subtraction of two numbers.
     * 
     * Converts input numbers to double to ensure 
     * consistent calculation across different numeric types.
     * 
     * @param num1 Number to be subtracted from
     * @param num2 Number to subtract
     * @return Result of the subtraction operation
     */
    @Override
    public Number apply(Number num1, Number num2) {
        return num1.doubleValue() - num2.doubleValue();
    }

    /**
     * Retrieves the corresponding Operation enum for this strategy.
     * 
     * @return The SUBTRACT operation from the Operation enum
     */
    @Override
    public Operation getOperation() {
        return Operation.SUBTRACT;
    }
}