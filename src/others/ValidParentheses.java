package others;

import java.util.Stack;

// Problem 20
// https://leetcode.com/problems/valid-parentheses/

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<String> stack = new Stack<String>();

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                stack.add(Character.toString(s.charAt(i)));
            if(s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
                if(stack.empty())
                    return false;

                String el = stack.pop();

                if(s.charAt(i) == ')' && !el.equals("(")) {
                    return false;
                }
                if(s.charAt(i) == ']' && !el.equals("[")) {
                    return false;
                }
                if(s.charAt(i) == '}' && !el.equals("{")) {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
