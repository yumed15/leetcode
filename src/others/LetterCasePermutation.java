package others;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    List<String> res = new ArrayList<>();

    public void helper(String s, int index) {
        if(index == s.length()) {
            res.add(s);
            return;
        }

        if(Character.isLetter(s.charAt(index))) {
            String aux = s.substring(0, index) + Character.toLowerCase(s.charAt(index)) + s.substring(index+1);
            String aux2 = s.substring(0, index) + Character.toUpperCase(s.charAt(index)) + s.substring(index+1);
            index++;
            helper(aux, index);
            helper(aux2, index);
        } else {
            index++;
            helper(s, index);
        }
    }
    public List<String> letterCasePermutation(String s) {
        helper(s, 0);
        return res;
    }
}
