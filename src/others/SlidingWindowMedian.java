package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class SlidingWindowMedian {

    public double getMedian(PriorityQueue<Integer> minHeap) {
        int size = minHeap.size()/2;
        for(int i=0; i<size; i++) {
            minHeap.poll();
        }
        if(size%2==0)
            return (minHeap.poll()+minHeap.poll())/2;
        else
            return minHeap.poll();
    }

    public double[] medianSlidingWindow(int[] nums, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        ArrayList<Double> res = new ArrayList<>();

        for(int i=0; i<k; i++) {
            queue.add(nums[i]);
        }
//        res.add(getMedian(queue));
        for(int i=k+1; i<nums.length-k; i++) {
            queue.remove(nums[i-1]);
            queue.add(nums[i+k]);
            System.out.println("--- " + queue);
//            res.add(getMedian(queue));
        }

        return res.stream().mapToDouble(d -> d).toArray();
    }
}

/*

[1,3,-1,-3,5,3,6,7]

k = 3
min -3 -1
max 1 3

 */