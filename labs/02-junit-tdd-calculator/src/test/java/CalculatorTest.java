import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void addition() {
        assertEquals(45, Calculator.addition(25, 20));
        assertEquals(15, Calculator.addition(5, 10));
    }

    @Test
    void subtraction() {
        assertEquals(5, Calculator.subtraction(25, 20));
        assertEquals(30, Calculator.subtraction(40, 10));
    }

    @Test
    void multiplication() {
        assertEquals(500, Calculator.multiplication(25, 20));
        assertEquals(400, Calculator.multiplication(40, 10));
    }

    @Test
    void division() {

        assertEquals(5, Calculator.division(25, 5));
        assertEquals(4, Calculator.division(40, 10));
    }
}