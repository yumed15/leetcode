package others;

// Problem 1456
// https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/?envType=study-plan-v2&envId=leetcode-75

public class MaximumNumberOfVowels {
    public int maxVowels(String s, int k) {

        int max = 0;
        for(int i=0; i<k; i++) {
            if (isVowel(s.charAt(i)))
                max++;
        }

        int i=0, j=k-1;
        int aux = max;
        while(j<s.length()-1){
            i++;
            j++;

            if(isVowel(s.charAt(i-1))) {
                aux--;
            }
            if(isVowel(s.charAt(j))) {
                aux++;
            }

            if(aux>max) {
                max = aux;
            }
        }

        return max;
    }

    public boolean isVowel(char c) {
        return (c == 'a') || (c == 'e') || (c == 'i') || (c == 'o') || (c == 'u');
    }
}
