package com.budati.calculator.service;

import com.budati.calculator.model.Operation;
import com.budati.calculator.model.OperationStrategy;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Service class responsible for performing mathematical calculations
 * using a strategy-based approach.
 * 
 * This service supports both single and chained mathematical operations
 * with a flexible and extensible design that allows for easy addition 
 * of new operation types.
 * 
 * Key Features:
 * - Supports dynamic operation selection via strategy pattern
 * - Handles complex chain calculations with operation priority
 * - Provides a robust error handling mechanism
 * 
 * @author Budati
 * @version 1.0
 * @since 2025-03-28
 */
@Service
public class CalculatorService {

    /**
     * Map storing the available mathematical operation strategies.
     * 
     * Each Operation enum is mapped to its corresponding implementation
     * of the OperationStrategy interface, enabling runtime strategy selection.
     */
    private final Map<Operation, OperationStrategy> operationMap;

    /**
     * Constructor for CalculatorService that accepts a map of operation strategies.
     * 
     * Uses Spring's dependency injection to provide a flexible configuration
     * of available mathematical operations.
     * 
     * @param operationMap A map of supported operations to their strategy implementations
     */
    @Autowired
    public CalculatorService(Map<Operation, OperationStrategy> operationMap) {
        this.operationMap = operationMap;
    }

    /**
     * Performs a single mathematical operation between two numbers.
     * 
     * Retrieves the appropriate operation strategy based on the 
     * provided Operation enum and applies it to the input numbers.
     * 
     * @param op The mathematical operation to perform
     * @param num1 The first number in the operation
     * @param num2 The second number in the operation
     * @return The result of the mathematical operation
     * @throws UnsupportedOperationException If no strategy is found for the given operation
     */
    public Number calculate(Operation op, Number num1, Number num2) {
        // Retrieve the strategy for the specified operation
        OperationStrategy strategy = operationMap.get(op);
        
        // Validate and execute the operation
        if (strategy != null) {
            return strategy.apply(num1, num2);
        } else {
            throw new UnsupportedOperationException("Operation not supported: " + op);
        }
    }

    /**
     * Performs a chain of mathematical operations with priority-based execution.
     * 
     * This method allows complex calculations by applying a sequence of operations
     * to an initial value. Operations are processed considering their priority,
     * similar to standard mathematical precedence rules.
     * 
     * Example: Starting with 2, chain [(MULTIPLY, 5), (ADD, 3)] would compute 2 * 5 + 3
     * 
     * Algorithm Steps:
     * 1. Initialize stacks for numbers and operations
     * 2. Process operations considering their priority
     * 3. Resolve operations from left to right while respecting precedence
     * 
     * @param initialValue The starting value for the chain of calculations
     * @param operations A list of operation-value pairs to apply sequentially
     * @return The final result after applying all operations
     */
    public Number chainCalculate(Number initialValue, List<Pair<Operation, Number>> operations) {
        // Stacks to manage numbers and operations during calculation
        Stack<Number> numbers = new Stack<>();
        Stack<Operation> operators = new Stack<>();

        // Push the initial value as the first number
        numbers.push(initialValue);

        // Process each operation in the chain
        for (Pair<Operation, Number> op : operations) {
            Operation currentOperation = op.getLeft();
            Number currentValue = op.getRight();

            // Handle operation priority by processing higher-priority operations first
            while (!operators.isEmpty() && currentOperation.getPriority() <= operators.peek().getPriority()) {
                // Resolve operations with higher or equal priority
                Number lastNumber = numbers.pop();
                Number secondLastNumber = numbers.pop();
                Operation lastOperator = operators.pop();

                Number result = calculate(lastOperator, secondLastNumber, lastNumber);
                numbers.push(result);
            }

            // Push current operation and value to respective stacks
            operators.push(currentOperation);
            numbers.push(currentValue);
        }

        // Process any remaining operations in the stack
        while (!operators.isEmpty()) {
            Operation operator = operators.pop();
            Number lastNumber = numbers.pop();
            Number secondLastNumber = numbers.pop();

            Number result = calculate(operator, secondLastNumber, lastNumber);
            numbers.push(result);
        }

        // Return the final calculated result
        return numbers.pop();
    }
}