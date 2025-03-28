package com.budati.calculator.model;

/**
 * Enumeration of mathematical operations supported by the calculator.
 * 
 * Provides a comprehensive set of operations with:
 * - Symbolic representation
 * - Calculation priority levels
 * - Utility methods for operation retrieval
 * 
 * Operation Hierarchy:
 * - Lower priority operations: ADD, SUBTRACT (priority 1)
 * - Higher priority operations: MULTIPLY, DIVIDE (priority 2)
 * - Highest priority: POWER (priority 3)
 * 
 * @author Budati
 * @version 1.0
 * @since 2025-03-28
 */
public enum Operation {
    // Define supported mathematical operations with symbols and priorities
    ADD("+", 1),
    SUBTRACT("-", 1),
    MULTIPLY("*", 2),
    DIVIDE("/", 2),
    POWER("^", 3);

    // Stores the symbolic representation of the operation
    private final String symbol;
    
    // Stores the calculation priority of the operation
    private final int priority;

    /**
     * Constructor for Operation enum.
     * 
     * @param symbol Symbolic representation of the operation
     * @param priority Calculation priority of the operation
     */
    Operation(String symbol, int priority) {
        this.symbol = symbol;
        this.priority = priority;
    }

    /**
     * Retrieves the symbolic representation of the operation.
     * 
     * @return Operation's symbol (e.g., "+", "-", "*")
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Retrieves the calculation priority of the operation.
     * 
     * @return Priority level for order of operations
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Retrieves an Operation enum based on its symbolic representation.
     * 
     * @param symbol Symbolic representation of the operation
     * @return Corresponding Operation enum
     * @throws IllegalArgumentException If no matching operation is found
     */
    public static Operation getBySymbol(String symbol) {
        for (Operation op : Operation.values()) {
            if (op.getSymbol().equals(symbol)) {
                return op;
            }
        }
        throw new IllegalArgumentException("Unknown operation symbol: " + symbol);
    }
}