import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestOddEvenChecker {
    @Test
    void testOddNumber() {
        Assertions.assertTrue(OddEvenChecker.isOddNumber(25));
        Assertions.assertTrue(OddEvenChecker.isOddNumber(15));
    }

    @Test
    void testEvenNumber() {
        Assertions.assertFalse(OddEvenChecker.isOddNumber(20));
        Assertions.assertFalse(OddEvenChecker.isOddNumber(10));
    }
}
