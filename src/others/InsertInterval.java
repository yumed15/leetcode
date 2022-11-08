package others;

import java.util.ArrayList;

// problem 57
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        ArrayList<int[]> result = new ArrayList<int[]>();

        for(int i=0; i<intervals.length; i++)
        {
            if(intervals[i][1] < newInterval[0]) // case 1 - doesn't intersect (left side)
            {
                result.add(intervals[i]);
            }
            else if (intervals[i][0] > newInterval[1]) // case 2 - doesn't intersect (right side)
            {
                result.add(newInterval);
                newInterval = intervals[i];
            }
            else if (intervals[i][1] >= newInterval[0] || intervals[i][0] <= newInterval[1]) // case 3 - intersects
            {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }

        result.add(newInterval);

        int[][] res = new int[result.size()][2];

        for(int i=0; i<result.size(); i++)
        {
            res[i][0] = result.get(i)[0];
            res[i][1] = result.get(i)[1];
        }

        return res;
    }
}
