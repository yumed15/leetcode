package others;

import java.util.HashMap;

// Problem 137
// https://leetcode.com/problems/single-number-ii

public class SingleNumberII {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
                if (map.get(num) == 2) {
                    map.remove(num);
                }
            } else {
                map.put(num, 0);
            }
        }

        for (Integer key : map.keySet()) {
            return key;
        }
        return -1;
    }
}
