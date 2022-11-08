package trees;

import java.util.ArrayList;
import java.util.List;

public class PathInZigZagTree {
    // first node in level = 2^level
    // last node in level = 2^(level+1)-1

    public int getLevelFromLabel(int label) {
        int level = 0;
        while (!(Math.pow(2, level) <= label) || !(label <= Math.pow(2, level + 1) - 1)) {
            level++;
        }
        return level;
    }

    public List<Integer> constructLevelOrderTraversal(int level) {
        List<Integer> tree = new ArrayList<>();
        for(int i=0; i<level; i++) {
            List<Integer> aux = new ArrayList<>();
            if(i%2==0) {
                for(int j = (int) Math.pow(2,i); j<=Math.pow(2,i+1)-1; j++)
                    aux.add(j);
            } else {
                for(int j = (int) (Math.pow(2,i+1)-1); j>=Math.pow(2,i); j--)
                    aux.add(j);
            }
            tree.addAll(aux);
        }
        return tree;
    }

    public void constructTreeFromLevelOrder(List<Integer> tree) {

        for(int i=0; i<tree.size(); i++) {

        }
    }
//
//    public int getPathToNode() {
//
//    }
//
//    public List<Integer> pathInZigZagTree(int label) {
//
//    }
}
