import org.example.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestCalculator {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }
    @Test
    public void testAddition() {
        assertEquals(45, calculator.addition(25, 20));
        assertEquals(15, calculator.addition(5, 10));
    }

    @Test
    public void testSubtraction() {
        assertEquals(5, calculator.subtract(25, 20));
        assertEquals(30, calculator.subtract(40, 10));
    }


    @Test
    void testMultiplication() {
        assertEquals(20, calculator.multiplication(4, 5));
        assertEquals(300, calculator.multiplication(30, 10));
    }

    @Test
    void testDivision() {
        assertEquals(4, calculator.division(20, 5));
        assertEquals(3, calculator.division(30, 10));
    }

}