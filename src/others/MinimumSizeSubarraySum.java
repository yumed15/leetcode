package others;

public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int min = nums.length + 1;
        while(i<nums.length) {
            int j = i;
            int sum = 0;
            while(j<nums.length && sum<target) {
                sum += nums[j];
                j++;
            }
            if(j-i+1<min && sum>=target)
                min = j-i+1;
            i++;
        }

        if(min == nums.length + 1)
            return 0;
        return min;
    }
}
