package others;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// Problem 46
// https://leetcode.com/problems/permutations/

public class Permutations {
    public void helper(int[] nums, int l, List<List<Integer>> res, HashSet<Integer> used, List<Integer> cur) {
        if (cur.size() == l) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int num : nums) {
            if (!used.contains(num)) {
                used.add(num);
                cur.add(num);
                helper(nums, l, res, used, cur);
                used.remove(num);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        HashSet<Integer> used = new HashSet<>();

        helper(nums, nums.length, res, used, new ArrayList<>());

        return res;
    }
}
