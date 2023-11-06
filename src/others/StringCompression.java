package others;

import java.util.ArrayList;

// Problem 443
// https://leetcode.com/problems/string-compression/description/?envType=study-plan-v2&envId=leetcode-75

public class StringCompression {
    public int compress(char[] chars) {

        if (chars.length == 1) return 1;

        int l=1;
        ArrayList<Character> ch = new ArrayList<>();
        ArrayList<String> freq = new ArrayList<>();
        for(int j=0; j<chars.length; j++) {
            if(j==chars.length-1 || chars[j]!=chars[j+1]){
                ch.add(chars[j]);
                freq.add(String.valueOf(l));
                l=1;
            } else {
                l++;
            }
        }

        int k=0;
        for(int i=0; i<ch.size(); i++) {
            chars[k] = ch.get(i);
            k++;
            for(int j=0; j<freq.get(i).length(); j++) {
                if(freq.get(i).charAt(j)=='1' && freq.get(i).length()==1)
                    continue;
                chars[k]=freq.get(i).charAt(j);
                k++;
            }
        }

        return k;
    }
}
