package others;

import java.util.PriorityQueue;


// problem 1405
public class LongestHappyString {
    class Node {
        char c;
        int remain;
        int count;

        public Node(char c, int remain, int count) {
            this.c = c;
            this.remain = remain;
            this.count = count;
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        Node A = new Node('a', a, 0);
        Node B = new Node('b', b, 0);
        Node C = new Node('c', c, 0);

        StringBuilder res = new StringBuilder();
        boolean picked = true;

        while (picked) {
            PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> { return Integer.compare(n2.remain, n1.remain); });
            pq.offer(A);
            pq.offer(B);
            pq.offer(C);
            picked = false;

            while (pq.size() > 0) {
                Node curr = pq.poll();
                if (curr.remain > 0 && curr.count < 2 && !picked) {
                    res.append(curr.c);
                    curr.remain --;
                    curr.count ++;
                    picked = true;
                } else {
                    curr.count = 0;
                }
            }
        }
        return res.toString();
    }
}
