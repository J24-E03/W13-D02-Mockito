package org.dcistudent;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestCalculatorTest {
    private static TestCalculator testCalculator;

    @BeforeAll
    static void setUp() {
        testCalculator = new TestCalculator();
    }

    @Test
    @DisplayName("Test add method")
    @Order(1)
    void add() {
        assertEquals(5, testCalculator.add(2, 3));
        assertEquals(0, testCalculator.add(-2, 2));
    }

    @Test
    @DisplayName("Test subtract method")
    @Order(2)
    void subtract() {
        assertEquals(1, testCalculator.subtract(3, 2));
        assertEquals(-4, testCalculator.subtract(-2, 2));
    }

    @Test
    @DisplayName("Test multiply method")
    @Order(3)
    void multiply() {
        assertEquals(6, testCalculator.multiply(2, 3));
        assertEquals(-4, testCalculator.multiply(-2, 2));
    }

    @Test
    @DisplayName("Test divide method")
    @Order(4)
    void divide() {
        assertEquals(2, testCalculator.divide(6, 3));
        assertEquals(-1, testCalculator.divide(-2, 2));
    }
}