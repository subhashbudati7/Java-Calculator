package com.budati.calculator.controller;

import com.budati.calculator.dto.CalculationRequest;
import com.budati.calculator.dto.MathematicalExpression;
import com.budati.calculator.model.Operation;
import com.budati.calculator.service.CalculatorService;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * RESTful controller for advanced mathematical calculations.
 * 
 * Provides endpoints for various calculation scenarios:
 * - Basic single operations
 * - Chained mathematical sequences
 * - Expression-based evaluations
 * 
 * @author Budati
 * @version 1.0
 * @since 2025-03-28
 */
@RestController
@RequestMapping("/api/computational")
public class ComputationalController {

    @Autowired
    private CalculatorService calculatorService;

    /**
     * Performs a single mathematical operation.
     * 
     * @param operation Selected mathematical operation
     * @param firstOperand First numeric value
     * @param secondOperand Second numeric value
     * @return Computation result
     */
    @PostMapping("/single-compute")
    public Number performSingleComputation(
            @RequestParam Operation operation, 
            @RequestParam Number firstOperand, 
            @RequestParam Number secondOperand) {
        return calculatorService.calculate(operation, firstOperand, secondOperand);
    }

    /**
     * Executes a sequence of mathematical operations.
     * 
     * @param request Calculation request with initial value and operation sequence
     * @return Computation result
     */
    @PostMapping("/sequence-compute")
    public String computeSequence(@RequestBody CalculationRequest request) {
        try {
            List<Pair<Operation, Number>> computationalSequence = request.getMathematicalSteps()
                    .stream()
                    .map(step -> {
                        Operation operation = Operation.getBySymbol(step.getOperationSymbol());
                        return Pair.of(operation, step.getOperationValue());
                    })
                    .collect(Collectors.toList());

            Number result = calculatorService.chainCalculate(request.getBaseNumeric(), computationalSequence);
            return result.toString();
        } catch (Exception e) {
            return "Invalid computational sequence";
        }
    }

    /**
     * Executes a sequence of mathematical operations with a default initial value of 5.
     * This overloaded method is primarily used for testing purposes.
     * 
     * @param operations List of operation-value pairs to execute
     * @return Computation result
     */
    public Number computeSequence(List<Pair<Operation, Number>> operations) {
        return calculatorService.chainCalculate(5, operations);
    }

    /**
     * Evaluates a free-form mathematical expression.
     * 
     * @param expression Mathematical expression input
     * @return Computation result
     */
    @PostMapping("/expression-compute")
    public String evaluateExpression(@RequestBody MathematicalExpression expression) {
        try {
            String[] expressionParts = expression.getRawExpression().split("\\s+");
            Number initialValue = parseNumericValue(expressionParts[0]);
            
            List<Pair<Operation, Number>> sequentialOperations = extractOperations(expressionParts);
            
            Number result = calculatorService.chainCalculate(initialValue, sequentialOperations);
            return result.toString();
        } catch (Exception e) {
            return "Invalid expression format";
        }
    }

    /**
     * Converts string representation to numeric value.
     * 
     * @param numericString String to convert
     * @return Numeric value
     */
    private Number parseNumericValue(String numericString) {
        try {
            return Integer.parseInt(numericString);
        } catch (NumberFormatException e) {
            return Double.parseDouble(numericString);
        }
    }

    /**
     * Extracts sequential operations from expression parts.
     * 
     * @param expressionParts Expression components
     * @return List of operation-value pairs
     */
    private List<Pair<Operation, Number>> extractOperations(String[] expressionParts) {
        List<Pair<Operation, Number>> sequentialOperations = new java.util.ArrayList<>();
        
        for (int index = 1; index < expressionParts.length; index += 2) {
            if (index + 1 < expressionParts.length) {
                Operation operation = Operation.getBySymbol(expressionParts[index]);
                Number value = parseNumericValue(expressionParts[index + 1]);
                sequentialOperations.add(Pair.of(operation, value));
            }
        }
        
        return sequentialOperations;
    }
}