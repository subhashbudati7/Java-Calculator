package com.budati.calculator.dto;

/**
 * Data Transfer Object for representing a mathematical expression.
 * 
 * Encapsulates a string-based mathematical expression for evaluation.
 * 
 * @author Budati
 * @version 1.0
 * @since 2025-03-28
 */
public class MathematicalExpression {
    // Raw mathematical expression as a string
    private String rawExpression;

    /**
     * Default constructor for framework compatibility.
     */
    public MathematicalExpression() {}

    /**
     * Constructs a mathematical expression with a given string.
     * 
     * @param rawExpression Mathematical expression
     */
    public MathematicalExpression(String rawExpression) {
        this.rawExpression = rawExpression;
    }

    /**
     * Retrieves the raw mathematical expression.
     * 
     * @return Expression string
     */
    public String getRawExpression() {
        return rawExpression;
    }

    /**
     * Sets the raw mathematical expression.
     * 
     * @param rawExpression Expression string
     */
    public void setRawExpression(String rawExpression) {
        this.rawExpression = rawExpression;
    }
}