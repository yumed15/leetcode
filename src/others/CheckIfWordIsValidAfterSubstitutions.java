package others;

// Problem 10003
// https://leetcode.com/problems/check-if-word-is-valid-after-substitutions

public class CheckIfWordIsValidAfterSubstitutions {
    public boolean isValid(String s) {

        while(s.contains("abc")){
            s = s.replaceAll("abc","");
        }

        return s.length() == 0;
    }
}
