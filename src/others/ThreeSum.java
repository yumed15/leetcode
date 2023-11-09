package others;

import java.util.*;

// Problem 15
// https://leetcode.com/problems/3sum/

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for (int num : nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        for (int i=0; i<nums.length; i++) {
            for (int j=0; j<nums.length; j++) {
                int aux = -nums[i] - nums[j];
                if ((aux==nums[i] || aux==nums[j]) && (map.containsKey(aux)) && map.get(aux)>1) {
                    if(!res.contains(Arrays.asList(nums[i], nums[j], aux)))
                        res.add(Arrays.asList(nums[i], nums[j], aux));
                }
                if (aux!=nums[i] && aux!=nums[j] && map.containsKey(aux)) {
                    if(!res.contains(Arrays.asList(nums[i], nums[j], aux)))
                        res.add(Arrays.asList(nums[i], nums[j], aux));
                }
            }
        }

        return res;
    }
}