package others;

import java.util.HashSet;
import java.util.Set;

// problem 3
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int i = 0; int j = 0;
        int res = 0;

        Set<Character> set = new HashSet<>();

        while(i<n && j<n)
        {
            if(!set.contains(s.charAt(j)))
            {
                set.add(s.charAt(j));
                j++;
                if(res < j-i)
                    res = j-i;
            }
            else
            {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return res;
    }

}
