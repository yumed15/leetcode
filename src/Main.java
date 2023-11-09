import others.MaximumSubarray;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MaximumSubarray p = new MaximumSubarray();
        int[] input = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(p.maxSubArray(input));
    }
}