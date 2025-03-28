package com.budati.calculator;

import com.budati.calculator.model.*;
import com.budati.calculator.service.CalculatorService;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test class for CalculatorService.
 * 
 * This class tests the core calculation logic of the CalculatorService,
 * verifying that different mathematical operations work correctly.
 * 
 * @author Budati
 * @version 1.0
 * @since 2025-03-28
 */
public class CalculatorServiceTest {

    // The service to be tested
    private CalculatorService calculatorService;

    /**
     * Set up method to initialize the CalculatorService with 
     * predefined operation strategies before each test.
     * 
     * Creates a map of operations to their corresponding strategy implementations,
     * ensuring each mathematical operation is properly configured.
     */
    @Before
    public void setUp() {
        // Create a map to hold different operation strategies
        Map<Operation, OperationStrategy> strategies = new HashMap<>();
        
        // Register strategies for different mathematical operations
        strategies.put(Operation.ADD, new Add());
        strategies.put(Operation.SUBTRACT, new Subtract());
        strategies.put(Operation.MULTIPLY, new Multiply());
        strategies.put(Operation.DIVIDE, new Divide());

        // Initialize the calculator service with the defined strategies
        calculatorService = new CalculatorService(strategies);
    }

    /**
     * Test the addition operation.
     * 
     * Verifies that the ADD operation correctly calculates the sum 
     * of two numbers.
     */
    @Test
    public void testAddOperation() {
        assertEquals(5.0, calculatorService.calculate(Operation.ADD, 2, 3));
    }

    /**
     * Test a complex chain of mathematical operations.
     * 
     * Verifies that the service can correctly process a sequence 
     * of different mathematical operations, applied in order.
     * 
     * The test calculates: 2 * 5 + 3 * 2 + 5 * 2 = 26
     */
    @Test
    public void testChainOperation1() {
        // Define a sequence of operations to be applied
        List<Pair<Operation, Number>> operations = Arrays.asList(
                Pair.of(Operation.MULTIPLY, 5),    // 2 * 5 = 10
                Pair.of(Operation.ADD, 3),         // 10 + 3 = 13
                Pair.of(Operation.MULTIPLY, 2),    // 13 * 2 = 26
                Pair.of(Operation.ADD, 5),         // 26 + 5 = 31
                Pair.of(Operation.MULTIPLY, 2)     // 31 * 2 = 62
        );
        
        // Verify the final result of the chain of operations
        assertEquals(26.0, calculatorService.chainCalculate(2, operations));
    }
}