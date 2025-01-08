import org.dci.OddOrEvenChecker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestOddEvenChecker {

    OddOrEvenChecker checker;

    @BeforeEach
    void setUp() {
        checker = new OddOrEvenChecker();
    }

    @Test
    void testOddNumber() {
        assertTrue(checker.isOddNumber(25));
        assertTrue(checker.isOddNumber(15));
    }

    @Test
    void testEvenNumber() {
        assertFalse(checker.isOddNumber(20));
        assertFalse(checker.isOddNumber(10));
    }

}
