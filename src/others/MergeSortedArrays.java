package others;

import java.util.ArrayList;
import java.util.List;

public class MergeSortedArrays {
    public void mergeArrays(int[] nums1, int m, int[] nums2, int n) {
        while(m>0 && n>0){
            if(nums1[m-1]>nums2[n-1]){
                nums1[n+m-1]=nums1[m-1];
                m--;
            } else {
                nums1[m+n-1]=nums2[n-1];
                n--;
            }
        }
        while(n>0){
            nums1[m+n-1] = nums2[n-1];
            n--;
        }
    }

    public static List<Integer> mergeSortedLists(List<Integer> list1, List<Integer> list2, int n) {
        List<Integer> mergedList = new ArrayList<>();
        int i = 0, j = 0;

        while (i < list1.size() && j < list2.size() && mergedList.size() < n) {
            if (list1.get(i) < list2.get(j)) {
                mergedList.add(list1.get(i));
                i++;
            } else {
                mergedList.add(list2.get(j));
                j++;
            }
        }

        while (i < list1.size() && mergedList.size() < n) {
            mergedList.add(list1.get(i));
            i++;
        }

        while (j < list2.size() && mergedList.size() < n) {
            mergedList.add(list2.get(j));
            j++;
        }

        return mergedList;
    }
}

