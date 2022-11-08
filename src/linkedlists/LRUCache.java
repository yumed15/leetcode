package linkedlists;

import java.util.HashMap;

// LRUCache
// [4, 5, 6 ,7]
// last recently used node is added at the end
// if capacity is max, node to remove is head

class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {
    Node head;
    Node tail;
    int capacity = 0;
    HashMap<Integer, Node> map = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if(!map.containsKey(key))
            return -1;

        Node res = map.get(key);
        remove(res);
        promote(res);

        return res.value;
    }

    // remove from list
    private void remove(Node t) {
        // t = head
        if(t.prev == null) {
            head = t.next;
        } else {
            t.prev.next = t.next;
        }

        // t = tail
        if(t.next == null) {
            tail = t.prev;
        } else {
            t.next.prev = t.prev;
        }
    }

    // move to tail
    private void promote(Node t) {
        if(tail != null) {
            tail.next = t;
        }

        t.prev = tail;
        t.next = null;
        tail = t;

        if(head == null) {
            head = tail;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node t = map.get(key);
            t.value = value;

            remove(t);
            promote(t);
        } else {
            if(map.size() >= capacity) {
                map.remove(head.key);
                remove(head);
            }

            Node t = new Node(key, value);
            promote(t);
            map.put(key, t);
        }
    }
}
