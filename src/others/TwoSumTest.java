package others;

import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.Arrays;

public class TwoSumTest {
    @Test
    public void testCalculateArea() {
        TwoSum sum = new TwoSum();
        Assert.assertEquals(Arrays.toString(sum.twoSum(new int[]{1,2,3,4}, 3)),
                Arrays.toString(new int[]{0,1}));
        Assert.assertEquals(sum.twoSum(new int[]{1,2,3,4}, 1), new int[]{0,0});
    }
}
