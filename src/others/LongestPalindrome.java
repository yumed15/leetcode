package others;

// problem 5
public class LongestPalindrome {

    public static int expandAroundMiddle(String s, int left, int right) {
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)) {
            left--;
            right++;
        }
        return right-left-1;
    }

    public static String longestPalindrome(String s) {

        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;
        for(int i=0; i<s.length(); i++) {
            int len1 = expandAroundMiddle(s, i, i);
            int len2 = expandAroundMiddle(s, i, i+1);

            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }
}
