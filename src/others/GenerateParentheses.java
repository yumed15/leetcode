package others;

import java.util.ArrayList;
import java.util.List;

// Problem 22
// https://leetcode.com/problems/generate-parentheses/

public class GenerateParentheses {
    public void generate(List<String> res, int n, String aux, int left, int right) {
        if(aux.length() == 2*n) {
            res.add(aux);
            return;
        }

        if(left<n)
            generate(res, n, aux+"(", left+1, right);
        if(right<left)
            generate(res, n, aux+")", left, right+1);
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        generate(res, n, "", 0, 0);
        return res;
    }
}
