package com.budati.calculator;

import com.budati.calculator.controller.ComputationalController;
import com.budati.calculator.model.Operation;
import com.budati.calculator.service.CalculatorService;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

/**
 * Unit test class for CalculatorController.
 * 
 * This class tests the interaction between the CalculatorController 
 * and CalculatorService using Mockito for mocking dependencies.
 * 
 * @author Budati
 * @version 1.0
 * @since 2025-03-28
 */
public class CalculatorControllerTest {
    
    // Mock the CalculatorService to isolate the controller's behavior
    @Mock
    private CalculatorService calculatorService;
    
    // Inject the mocked service into the controller
    @InjectMocks
    private ComputationalController computationalController;
    
    /**
     * Set up method to initialize Mockito annotations before each test.
     * 
     * This method ensures that Mockito can properly inject mocks 
     * and prepare the test environment.
     */
    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    /**
     * Test the basic calculation method of the CalculatorController.
     * 
     * Verifies that:
     * 1. The controller delegates calculation to the service
     * 2. The correct result is returned
     * 3. The service method is called with correct parameters
     */
    @Test
    public void testCalculate() {
        // Arrange: Prepare mock behavior for the service
        when(calculatorService.calculate(Operation.ADD, 2, 3)).thenReturn(5);

        // Act: Invoke the controller method
        Number result = computationalController.performSingleComputation(Operation.ADD, 2, 3);

        // Assert: Verify the result and service interaction
        assertEquals(5, result);
        verify(calculatorService).calculate(Operation.ADD, 2, 3);
    }
    
    /**
     * Test the chain calculation method of the CalculatorController.
     * 
     * Verifies that:
     * 1. The controller can handle a sequence of operations
     * 2. The service is called with the correct chain of operations
     * 3. The final result is correct
     */
    @Test
    public void testChainCalculate() {
        // Arrange: Prepare a list of operations and mock the service response
        List<Pair<Operation, Number>> operations = Arrays.asList(
                Pair.of(Operation.ADD, 3),
                Pair.of(Operation.MULTIPLY, 2)
        );
        when(calculatorService.chainCalculate(5, operations)).thenReturn(16);

        // Act: Invoke the chain calculation method
        Number result = computationalController.computeSequence(operations);

        // Assert: Verify the result and service interaction
        assertEquals(16, result);
        verify(calculatorService).chainCalculate(5, operations);
    }
}