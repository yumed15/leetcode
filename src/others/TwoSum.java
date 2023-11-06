package others;

import java.util.Arrays;
import java.util.List;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        List<Integer> l = Arrays.stream(nums).boxed().toList();
        int[] res = new int[2];
        for(int i=0; i<l.size(); i++) {
            if(l.contains(target-l.get(i))) {
                int index = getIndex(l,target-l.get(i));
                if(index!=i) {
                    res[0] = i;
                    res[1] = index;
                    break;
                }
            }

        }
        return res;
    }

    public int getIndex(List<Integer> l, int e) {
        for(int i=0; i<l.size(); i++) {
            if (l.get(i) == e) {
                return i;
            }
        }
        return -1;
    }
}
