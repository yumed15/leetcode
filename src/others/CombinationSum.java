package others;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    void helper(int[] candidates, int target, List<List<Integer>> res, List<Integer> temp, int start, int sum) {
        if(sum>target)
            return;

        if(sum==target) {
            res.add(new ArrayList<>(temp));
            return;
        }

        if(sum<target) {
            for(int i=start; i<candidates.length; i++) {
                temp.add(candidates[i]);
                helper(candidates, target, res, temp, i, sum+candidates[i]);
                temp.remove(temp.size()-1);
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        helper(candidates, target, res, temp, 0, 0);
        return res;
    }
}
