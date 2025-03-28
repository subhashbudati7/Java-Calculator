package com.budati.calculator.model;

import org.springframework.stereotype.Component;

/**
 * Implementation of power (exponentiation) operation strategy.
 * 
 * Provides a concrete strategy for performing exponential calculations
 * within the calculator's flexible operation framework.
 * 
 * Key Features:
 * - Uses Java's Math.pow for precise exponential calculations
 * - Supports raising numbers to various powers
 * - Integrates seamlessly with other operation strategies
 * 
 * @author Budati
 * @version 1.0
 * @since 2025-03-28
 */
@Component
public class Power implements OperationStrategy {
    
    /**
     * Performs power (exponentiation) operation on two numbers.
     * 
     * Utilizes Math.pow for accurate exponential calculations.
     * Converts input numbers to double for consistent processing.
     * 
     * @param num1 Base number
     * @param num2 Exponent
     * @return Result of raising num1 to the power of num2
     */
    @Override
    public Number apply(Number num1, Number num2) {
        return Math.pow(num1.doubleValue(), num2.doubleValue());
    }
    
    /**
     * Retrieves the corresponding Operation enum for this strategy.
     * 
     * @return The POWER operation from the Operation enum
     */
    @Override
    public Operation getOperation() {
        return Operation.POWER;
    }
}