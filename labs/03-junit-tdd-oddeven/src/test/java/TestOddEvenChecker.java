import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestOddEvenChecker {
    OddOrEvenChecker oddOrEvenChecker = new OddOrEvenChecker();


    @Test
    public void testOddNumber() {
        assertTrue(oddOrEvenChecker.isOddNumber(25));
        assertTrue(oddOrEvenChecker.isOddNumber(15));
    }
    @Test
    public void testEvenNumber() {
        assertFalse(oddOrEvenChecker.isOddNumber(20));
        assertFalse(oddOrEvenChecker.isOddNumber(10));
    }





}
