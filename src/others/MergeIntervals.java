package others;

// Problem 56
// https://leetcode.com/problems/merge-intervals/

import java.util.*;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] idx1, int[] idx2) {
                return Integer.compare(idx1[0], idx2[0]);
            }});

        Stack<int[]> stack = new Stack<>();
        stack.add(intervals[0]);

        int n = 1;
        for(int i=1; i<intervals.length; i++){
            int[] top = stack.peek();

            if(top[1]<intervals[i][0]){
                stack.add(intervals[i]);
                n++;
            }else if(top[1]>intervals[i][0] && top[1] <= intervals[i][1]){
                stack.pop();
                int[] temp = {top[0], intervals[i][1]};
                stack.add(temp);
            }
        }

        int[][] res = new int[n][2];
        int j = 0;
        while(!stack.empty())
        {
            res[j] = stack.peek();
            stack.pop();
            j++;
        }

        return res;
    }
}
