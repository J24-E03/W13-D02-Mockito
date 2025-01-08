import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OddEvenCheckerTest {
    private static OddEvenChecker checker;

    @BeforeEach
    void setUp() {
        checker = new OddEvenChecker();
    }

    @Test
    void isEven() {
        assertTrue(checker.isEven(2));
        assertFalse(checker.isEven(3));
    }

    @Test
    void isOdd() {
        assertFalse(checker.isOdd(2));
        assertTrue(checker.isOdd(3));
    }
}