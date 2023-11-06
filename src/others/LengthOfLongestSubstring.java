package others;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

    public int lengthOfLongestSubstring2(String s) {
        if (s.length() <= 1) return s.length();

        int l = 0, i = 0, j = 1;
        HashSet<Character> set = new HashSet<>();
        set.add(s.charAt(i));

        while (j<s.length()) {
            if(set.contains(s.charAt(j))) {
                set.clear();
                i++;
                set.add(s.charAt(i));
                j=i+1;
            } else {
                set.add(s.charAt(j));
                j++;
            }
            if(l<j-i)
                l=j-i;
        }
        return l;
    }

    public int lengthOfLongestSubstring3(String s) {

        if (s.length()==1) return 1;

        int i = 0, j = 1, max=0;
        String res = "";
        List<Character> w = new ArrayList<>();

        while(j<s.length()){
            if(!w.contains(s.charAt(i)))
                w.add(s.charAt(i));
            if (w.size() > max) {
                max = w.size();
                res = w.toString();
            }

            if(!w.contains(s.charAt(j)))
                w.add(s.charAt(j));
            else{
                while(w.size()!=0 && w.contains(s.charAt(j))) {
                    w.remove(w.get(0));
                    i++;
                }
                w.add(s.charAt(j));
            }
            j++;
            if (w.size() > max) {
                max = w.size();
                res = w.toString();
            }
        }

        System.out.println(res);
        return max;
    }

}
