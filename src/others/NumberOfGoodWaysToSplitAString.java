package others;

import java.util.HashMap;

public class NumberOfGoodWaysToSplitAString {

    public int numSplits(String s) {
        if(s.length() == 1) return 0;

        int count = 0;
        HashMap<Character, Integer> left = new HashMap<>();
        HashMap<Character, Integer> right = new HashMap<>();

        left.put(s.charAt(0), 1);

        for(int i=1; i<s.length(); i++) {
            if(right.containsKey(s.charAt(i)))
                right.put(s.charAt(i), right.get(s.charAt(i))+1);
            else
                right.put(s.charAt(i), 1);
        }

        for(int i=1; i<s.length()-1; i++) {
            if(left.size() == right.size()) count++;

            // add to left
            if(left.containsKey(s.charAt(i)))
                left.put(s.charAt(i), left.get(s.charAt(i))+1);
            else
                left.put(s.charAt(i), 1);

            // remove from right
            if(right.get(s.charAt(i))>1)
                right.put(s.charAt(i), right.get(s.charAt(i))-1);
            else
                right.remove(s.charAt(i));
        }

        return count;
    }
}
