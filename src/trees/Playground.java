package trees;

import java.util.HashSet;

public class Playground {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length; i++)
            set.add(nums[i]);

        int res = 0;

        for(int num: set) {
            if(!set.contains(num-1)) {
                int l = 1;
                int start = num + 1;
                while (set.contains(start)) {
                    start++;
                    l++;
                }
                if (l > res)
                    res = l;
            }
        }
        return res;
    }
}
