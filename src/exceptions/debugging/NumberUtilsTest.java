package exceptions.debugging;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberUtilsTest {

    @org.junit.jupiter.api.Test
    void testDifference(){
        NumberUtils nu = new NumberUtils();
        assertEquals(20, nu.difference(25, 5), "Pro vstupy 25 - 5");
        assertEquals(45, nu.difference(50, 5), "Pro vstupy 50 - 5");
    }

}