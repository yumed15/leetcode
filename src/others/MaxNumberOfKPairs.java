package others;

// Problem 1679
// https://leetcode.com/problems/max-number-of-k-sum-pairs/description/?envType=study-plan-v2&envId=leetcode-75

import java.util.HashMap;

public class MaxNumberOfKPairs {
    public int maxOperations(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else {
                map.put(num, 1);
            }
        }

        int ok = 0;
        for (int num : nums) {
            if (map.containsKey(num) && map.containsKey(k-num)) {
                if ((num==k-num) && (map.get(num)<2))
                    continue;
                ok++;
                map.put(num, map.get(num)-1);
                map.put(k-num, map.get(k-num)-1);

                if(map.get(num)==0)
                    map.remove(num);
                if(map.containsKey(k-num) && map.get(k-num)==0)
                    map.remove(k-num);
            }
        }

        return ok;
    }
}
