package com.budati.calculator.dto;

import java.util.List;

/**
 * Data Transfer Object representing a complex calculation request.
 * 
 * Encapsulates the initial value and a sequence of mathematical operations
 * to be performed in a specific order.
 * 
 * @author Budati
 * @version 1.0
 * @since 2025-03-28
 */
public class CalculationRequest {
    // Starting numeric value for the calculation sequence
    private Number baseNumeric;
    
    // Sequence of mathematical transformations to apply
    private List<OperationDescriptor> mathematicalSteps;

    /**
     * Retrieves the base numeric value for calculation.
     * 
     * @return Initial numeric value
     */
    public Number getBaseNumeric() {
        return baseNumeric;
    }

    /**
     * Sets the base numeric value for calculation.
     * 
     * @param baseNumeric Initial numeric value
     */
    public void setBaseNumeric(Number baseNumeric) {
        this.baseNumeric = baseNumeric;
    }

    /**
     * Retrieves the sequence of mathematical operations.
     * 
     * @return List of operation descriptors
     */
    public List<OperationDescriptor> getMathematicalSteps() {
        return mathematicalSteps;
    }

    /**
     * Sets the sequence of mathematical operations.
     * 
     * @param mathematicalSteps List of operation descriptors
     */
    public void setMathematicalSteps(List<OperationDescriptor> mathematicalSteps) {
        this.mathematicalSteps = mathematicalSteps;
    }
}