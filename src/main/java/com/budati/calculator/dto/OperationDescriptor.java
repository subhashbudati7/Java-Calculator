package com.budati.calculator.dto;

/**
 * Represents a single mathematical operation descriptor.
 * 
 * Captures the type of operation and its associated numeric value.
 * 
 * @author Budati
 * @version 1.0
 * @since 2025-03-28
 */
public class OperationDescriptor {
    // Symbolic representation of the mathematical operation
    private String operationSymbol;
    
    // Numeric value to be used in the operation
    private Number operationValue;

    /**
     * Retrieves the operation's symbolic representation.
     * 
     * @return Operation symbol
     */
    public String getOperationSymbol() {
        return operationSymbol;
    }

    /**
     * Sets the operation's symbolic representation.
     * 
     * @param operationSymbol Operation symbol
     */
    public void setOperationSymbol(String operationSymbol) {
        this.operationSymbol = operationSymbol;
    }

    /**
     * Retrieves the numeric value for the operation.
     * 
     * @return Numeric value
     */
    public Number getOperationValue() {
        return operationValue;
    }

    /**
     * Sets the numeric value for the operation.
     * 
     * @param operationValue Numeric value
     */
    public void setOperationValue(Number operationValue) {
        this.operationValue = operationValue;
    }
}