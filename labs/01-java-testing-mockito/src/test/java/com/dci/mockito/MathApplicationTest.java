package com.dci.mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MathApplicationTest {

    @InjectMocks
    MathApplication mathApplication = new MathApplication();

    @Mock
    CalculatorService calcService ;

    @Test
    @DisplayName("Use of When()  and thenReturn()")
    public void testMathApplicationUsingWhen() {
        //TODO: add the expectations of calc service calls

        when(calcService.add(10.0,20.0)).thenReturn(30.0);
        when(calcService.subtract(20.0,10.0)).thenReturn(30.0);
        when(calcService.divide(20.0,2.0)).thenReturn(10.0);
        when(calcService.multiply(10.0,20.0)).thenReturn(200.0);

        Assertions.assertEquals(mathApplication.add(10.0, 20.0), 30.0);
        Assertions.assertEquals(mathApplication.subtract(20.0, 10.0), 10.0);
        Assertions.assertEquals(mathApplication.divide(20.0, 2.0), 15.0);
        Assertions.assertEquals(mathApplication.multiply(10.0, 20.0), 200.0);
    }

    @Test
    @DisplayName("Verify method calls")
    public void testMathApplicationUsingVerify() {

        mathApplication.add(10.0, 20.0);
        mathApplication.subtract(20.0, 10.0);
        mathApplication.divide(20.0, 2.0);
        mathApplication.multiply(10.0, 20.0);

        //TODO: verify calc service calls made for the above calls
        verify(calcService.add(10.0,20.0));
        verify(calcService.subtract(20.0,10.0));
        verify(calcService.divide(20.0,2.0));
        verify(calcService.multiply(10.0,20.0));
    }

    @Test
    @DisplayName("No' of method invocations/calls")
    public void testVerifyNoOfMethodCalls() {

        mathApplication.add(10.0, 20.0);
        mathApplication.add(10.0, 20.0);
        mathApplication.add(10.0, 20.0);

        mathApplication.subtract(20.0, 10.0);
        mathApplication.subtract(20.0, 10.0);

        mathApplication.divide(20.0, 2.0);

        //TODO: verify calc service calls made for the above calls
        verify(calcService, times(3)).add(10.0,20.0);
        verify(calcService, times(2)).subtract(20.0, 10.0);
        verify(calcService, times(1)).divide(20.0, 2.0);
        verify(calcService,never()).multiply(anyDouble(),anyDouble());


    }

    @Test
    @DisplayName("No' of method invocations/calls - 2")
    public void testVerifyNoOfMethodCalls2() {

        mathApplication.add(10.0, 20.0);
        mathApplication.add(10.0, 20.0);
        mathApplication.add(10.0, 20.0);

        mathApplication.subtract(20.0, 10.0);
        mathApplication.subtract(20.0, 10.0);

        mathApplication.divide(20.0, 2.0);

        //TODO: verify calc service calls made for the above calls
        verify(calcService, atMost(3)).add(10.0, 20.0);
        verify(calcService, atLeast(2)).subtract(20.0, 10.0);
        verify(calcService, atLeastOnce()).divide(20.0, 2.0);
        verify(calcService, never()).multiply(anyDouble(), anyDouble());


    }

    @Test
    @DisplayName("Exception Handling")
    public void verify_ExceptionHandling() {

        //TODO:add the expected exceptions thrown for the below method calls
        when(calcService.add(0.0,0.0)).thenThrow(new RuntimeException("Both arguments cannot be zero"));
        when(calcService.subtract(30.0,30.0)).thenThrow(new IllegalArgumentException("Invalid Arguments"));
        when(calcService.divide(20.0,0.0)).thenThrow(new ArithmeticException("Cannot be divided by zero"));


        RuntimeException runtimeException = Assertions.assertThrows(RuntimeException.class, () -> mathApplication.add(0, 0));
        Assertions.assertEquals(runtimeException.getMessage(), "Both Arguments can not be zero");

        IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class, () -> mathApplication.subtract(20.0, 20.0));
        Assertions.assertEquals(illegalArgumentException.getMessage(), "Invalid Arguments");

        ArithmeticException arithmeticException = Assertions.assertThrows(ArithmeticException.class, () -> mathApplication.divide(20.0, 0.0));
        Assertions.assertEquals(arithmeticException.getMessage(), "Can not be divided by zero");
    }


    @Test
    @DisplayName("Verify Method call sequence/order")
    public void verify_OrderOfMethodExecution() {

        when(calcService.add(10.0, 20.0)).thenReturn(30.00);
        when(calcService.subtract(20.0, 10.0)).thenReturn(10.00);
        when(calcService.divide(20.0, 2.0)).thenReturn(10.00);
        when(calcService.multiply(10.0, 20.0)).thenReturn(200.00);

        Assertions.assertEquals(mathApplication.subtract(20.0, 10.0), 10.0);
        Assertions.assertEquals(mathApplication.multiply(10.0, 20.0), 200.0);
        Assertions.assertEquals(mathApplication.divide(20.0, 2.0), 10.0);
        Assertions.assertEquals(mathApplication.add(10.0, 20.0), 30.0);

        //TODO:Verify Method call execution order
        InOrder inOrder= inOrder(calcService);
        inOrder.verify(calcService).add(10.0,20.0);
        inOrder.verify(calcService).subtract(20.0,10.0);
        inOrder.verify(calcService).divide(20.0,2.0);


    }

  
}