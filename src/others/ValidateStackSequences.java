package others;

import java.util.Stack;

// Problem 946
// https://leetcode.com/problems/validate-stack-sequences

public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();

        int j=0;
        for (int k : pushed) {
            st.add(k);
            while(!st.empty() && popped[j] == st.peek()) {
                j++;
                st.pop();
            }
        }

        return j == popped.length && st.empty();
    }
}
