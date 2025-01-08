import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OddEvenCheckerInterfaceTest {
    @Test
    @Order(1)
    void isEven() {
        OddEvenCheckerInterface checker = mock(OddEvenCheckerInterface.class);
        when(checker.isEven(2)).thenReturn(true);
        when(checker.isEven(3)).thenReturn(false);

        assertTrue(checker.isEven(2));
        assertFalse(checker.isEven(3));
    }

    @Test
    @Order(2)
    void isOdd() {
        OddEvenCheckerInterface checker = mock(OddEvenCheckerInterface.class);
        when(checker.isOdd(2)).thenReturn(false);
        when(checker.isOdd(3)).thenReturn(true);

        assertFalse(checker.isOdd(2));
        assertTrue(checker.isOdd(3));
    }
}