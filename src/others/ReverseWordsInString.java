package others;

import java.util.ArrayList;

public class ReverseWordsInString {
    public static String reverseWords(String s) {

        String[] splitted = s.split("\\s+");
        StringBuilder res = new StringBuilder();


        for(int i=splitted.length-1; i>=0; i--) {
            splitted[i] = splitted[i].replaceAll("[^a-zA-Z0-9]", "");

            if(!splitted[i].equals("")) {
                res.append(splitted[i]);
                res.append(" ");
            }
        }

        if(res.charAt(res.length()-1)==' ')
            res.deleteCharAt(res.length()-1);

        return res.toString();
    }
}
