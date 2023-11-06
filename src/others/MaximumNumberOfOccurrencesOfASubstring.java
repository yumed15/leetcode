package others;

import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

public class MaximumNumberOfOccurrencesOfASubstring {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {

        HashMap<String, Integer> count = new HashMap<>();
        int max_count = 0;

        for(int i=0; i<=s.length()-minSize; i++) {
            int j=i+minSize;
            while(j-i<=maxSize && j<=s.length()) {
                String aux = s.substring(i,j);
                if(getUniqueLetters(aux)>maxLetters)
                    break;
                if(count.containsKey(aux)){
                    count.put(aux, count.get(aux)+1);
                }else{
                    count.put(aux, 1);
                }
                if(count.get(aux)>max_count) {
                    max_count = count.get(aux);
                }
                j++;
            }
        }
        return max_count;
    }

    public int getUniqueLetters(String s){
        Set<Character> charsSet = s.chars().mapToObj(e->(char)e).collect(Collectors.toSet());
        return charsSet.size();
    }
}
