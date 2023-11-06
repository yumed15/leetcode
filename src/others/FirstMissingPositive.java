package others;

import java.util.HashSet;
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for(int i=1; i<Integer.MAX_VALUE; i++) {
            if(!set.contains(i))
                return i;
        }

        return 0;
    }
}
