package others;

public class MaximumRepeatedSubstring {
    public int maxRepeating(String sequence, String word) {

        int count = 0;
        for(int i=0; i<sequence.length()-word.length()+1; i++){
            if(sequence.substring(i, i+word.length()).equals(word))
                count++;
        }

        return count;
    }
}
