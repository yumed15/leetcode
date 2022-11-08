package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    private void helper(int[] candidates, int start, int remain, List<Integer> aux, List<List<Integer>> res) {
        if(remain == 0) {
            res.add(new ArrayList<>(aux));
            return;
        }
        if (remain < 0) {
            return;
        }

        for(int i=start; i<candidates.length; i++) {
            if(i > start && candidates[i] == candidates[i - 1]) continue;
            aux.add(candidates[i]);
            helper(candidates, i+1, remain-candidates[i], aux, res);
            aux.remove(aux.size()-1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }
}
