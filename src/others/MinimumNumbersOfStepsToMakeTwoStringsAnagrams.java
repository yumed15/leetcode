package others;

import java.util.HashMap;

public class MinimumNumbersOfStepsToMakeTwoStringsAnagrams {

    public int minSteps(String s, String t) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        for (char c : t.toCharArray()){
            map[c - 'a']--;
        }
        int ans = 0;
        for (int i : map) {
            ans += Math.abs(i);
        }
        return ans / 2;
    }
//
//    public int minSteps(String s, String t) {
//
//        HashMap<Character, Integer> count = new HashMap<>();
//        for(int i=0; i<s.length(); i++) {
//            if(count.containsKey(s.charAt(i)))
//                count.put(s.charAt(i), count.get(s.charAt(i))+1);
//            else
//                count.put(s.charAt(i), 1);
//        }
//
//        for(int i=0; i<t.length(); i++) {
//            if(count.containsKey(t.charAt(i)))
//                count.put(t.charAt(i), count.get(t.charAt(i))-1);
//            else
//                count.put(t.charAt(i), 1);
//        }
//
//        int res = 0;
//        for(Character c : count.keySet()) {
//            if(count.containsKey(c))
//                res += Math.abs(count.get(c));
//        }
//
//        return res;
//    }
}
