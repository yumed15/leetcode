package others;

// Problem 53
// https://leetcode.com/problems/maximum-subarray/

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0;

        for (int num : nums) {
            max_ending_here = max_ending_here + num;
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }
}
