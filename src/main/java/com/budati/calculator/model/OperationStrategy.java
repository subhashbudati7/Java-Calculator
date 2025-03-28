package com.budati.calculator.model;

/**
 * Strategy interface for mathematical operations.
 * 
 * Defines a contract for implementing mathematical operations
 * within the calculator's flexible and extensible design.
 * 
 * Key Responsibilities:
 * - Define a method to apply the operation
 * - Provide a way to identify the operation type
 * 
 * Design Pattern: Strategy Pattern
 * 
 * @author Budati
 * @version 1.0
 * @since 2025-03-28
 */
public interface OperationStrategy {
    
    /**
     * Apply the mathematical operation to two numbers.
     * 
     * @param num1 First number in the operation
     * @param num2 Second number in the operation
     * @return Result of the mathematical operation
     */
    Number apply(Number num1, Number num2);
    
    /**
     * Retrieve the specific operation type.
     * 
     * @return The Operation enum corresponding to this strategy
     */
    Operation getOperation();
}