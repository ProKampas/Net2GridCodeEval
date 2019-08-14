package jetbrains;

import org.junit.Test;

import static org.junit.Assert.*;

public class StatisticUtilsArrayTest {
    private StatisticUtilsArray sua = new StatisticUtilsArray();
    private double[] data = new double[] {0,1,2,3,4,4,5,6,7,8,9};

    @Test
    public void minValue() throws Exception{
        double expectedValue = 0;
        assertEquals(expectedValue, sua.minValue(data), 0.001);
    }


}