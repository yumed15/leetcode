package others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SnapshotArray {

    HashMap<Integer, List<Integer>> snapshots = new HashMap<>();
    int snapshot_count = 0;

    public SnapshotArray(int length) {
        List<Integer> snapshot = new ArrayList<>();
        for(int i=0; i<length; i++)
            snapshot.add(0);
        this.snapshots.put(this.snapshot_count, snapshot);
    }

    public void set(int index, int val) {
        List<Integer> snapshot = new ArrayList<>();
        snapshot.addAll(this.snapshots.get(this.snapshot_count));
        snapshot.set(index, val);
        this.snapshots.put(this.snapshot_count, snapshot);
    }

    public int snap() {
        List<Integer> snapshot = this.snapshots.get(this.snapshot_count);
        this.snapshot_count = this.snapshot_count+1;
        this.snapshots.put(this.snapshot_count, snapshot);
        return this.snapshot_count-1;
    }

    public int get(int index, int snap_id) {
        List<Integer> snapshot = this.snapshots.get(snap_id);
        return snapshot.get(index);
    }
}
