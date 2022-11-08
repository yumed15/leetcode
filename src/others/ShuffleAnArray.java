package others;

import java.util.Random;

public class ShuffleAnArray {

    private int[] original;

    public void Solution(int[] nums) {
        this.original = nums;
    }

    public int[] reset() {
        return original;
    }

    public int[] shuffle() {
        Random rand = new Random();
        int[] shuffled = new int[this.original.length];
        int[] visited = new int[this.original.length];

        int i=0;
        while (i<this.original.length) {
            int random = rand.nextInt(this.original.length);
            if(visited[random] == 0) {
                shuffled[random] = this.original[i];
                visited[random] = 1;
                i++;
            }
        }
        return shuffled;
    }
}
