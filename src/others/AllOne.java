package others;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

//432. All O`one Data Structure

class NodeObj implements Comparable<NodeObj> {
    private String key;
    private int value;

    NodeObj(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getKey() {
        return this.key;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public int compareTo(NodeObj other) {
        return this.getValue() - other.getValue();
    }
}

public class AllOne {

    HashMap<String, NodeObj> map;
    PriorityQueue<NodeObj> pq_min;
    PriorityQueue<NodeObj> pq_max;

    public AllOne() {
        this.map = new HashMap<>();
        this.pq_min = new PriorityQueue<>();
        this.pq_max = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void inc(String key) {
        if(map.containsKey(key)) {
            int value = map.get(key).getValue();
            pq_min.remove(map.get(key));
            pq_max.remove(map.get(key));
            map.put(key, new NodeObj(key, value+1));
        } else {
            map.put(key, new NodeObj(key, 1));
        }
        pq_min.add(map.get(key));
        pq_max.add(map.get(key));

    }

    public void dec(String key) {
        pq_min.remove(map.get(key));
        pq_max.remove(map.get(key));
        if(map.get(key).getValue()-1==0) {
            map.remove(key);
        } else {
            map.put(key, new NodeObj(key, map.get(key).getValue()-1));
            pq_min.add(map.get(key));
            pq_max.add(map.get(key));
        }
    }

    public String getMinKey() {
        if (pq_min.peek()!=null)
            return pq_min.peek().getKey();
        else
            return "";
    }

    public String getMaxKey() {
        if (pq_max.peek()!=null)
            return pq_max.peek().getKey();
        else
            return "";
    }

}

