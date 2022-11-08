package others;

import java.util.Stack;

public class MinimumAddToMakeParanthesesValid {
    public int minAddToMakeValid(String s) {

        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            if(!st.empty()) {
                if(st.peek()=='(' && s.charAt(i)==')')
                    st.pop();
                else
                    st.add(s.charAt(i));
            } else
                st.add(s.charAt(i));
        }

        return st.size();
    }
}


/*

())

)
 */