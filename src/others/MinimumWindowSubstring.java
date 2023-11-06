package others;

import java.util.HashMap;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> dict = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), 0);

            if (dict.containsKey(t.charAt(i))) {
                dict.put(t.charAt(i), dict.get(t.charAt(i)) + 1);
            } else {
                dict.put(t.charAt(i), 1);
            }
        }

        int start = 0;
        int count = 0;
        int minLen = s.length() + 1;
        String result = "";

        for (int end = 0; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end))) {
                map.put(s.charAt(end), map.get(s.charAt(end)) + 1);

                if (map.get(s.charAt(end)) <= dict.get(s.charAt(end))) {
                    count++;
                }
            }

            if (count == t.length()) {
                while (!dict.containsKey(s.charAt(start)) || map.get(s.charAt(start)) > dict.get(s.charAt(start))) {
                    if (map.containsKey(s.charAt(start))) {
                        map.put(s.charAt(start), map.get(s.charAt(start))-1);
                    }
                    start++;
                }

                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    result = s.substring(start, end + 1);
                }
            }
        }
        return result;
    }
}
