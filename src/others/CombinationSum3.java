package others;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public void helper(int start, int n, int k, List<Integer> aux, List<List<Integer>> res) {
        if(n==0) {
            if (aux.size() == k)
                res.add(new ArrayList<>(aux));
            return;
        }

        for(int i=start; i<=9; i++) {
            aux.add(i);
            helper(i+1, n-i, k, aux, res);
            aux.remove(aux.size()-1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();

        helper(1, n, k, new ArrayList<Integer>(), res);
        return res;
    }
}

