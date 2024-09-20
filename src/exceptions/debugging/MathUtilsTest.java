package exceptions.debugging;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {


    @Test
    public void testAverageSimple(){
        MathUtils utils = new MathUtils();
        assertEquals(2.0, utils.getAverage(new int[]{1,2,3}), 0.001 );
        assertEquals(0.0, utils.getAverage(new int[]{0,0,0}), 0.001 );
        assertEquals(-2.0, utils.getAverage(new int[]{-1,-2,-3}), 0.001 );
    }

    @Test
    public void testAverageNulls(){
        MathUtils utils = new MathUtils();
        assertEquals(0.0, utils.getAverage(new int[]{}), 0.001);
        assertEquals(0.0, utils.getAverage(null), 0.001);
    }

    @Test
    public void advancedTestAverage(){
        MathUtils utils = new MathUtils();
        assertEquals(1.5, utils.getAverage(new int[]{1,2}));
    }
}