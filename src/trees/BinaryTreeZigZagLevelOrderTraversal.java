package trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigZagLevelOrderTraversal {

    public int getHeight(TreeNode root) {
        if(root==null) return 0;
        return 1+Math.max(getHeight(root.left), getHeight(root.right));
    }

    public List<Integer> getLevelNodes(TreeNode root, int level, List<Integer> aux) {
        if(root==null) return aux;
        if(level==1)
            aux.add(root.val);
        if(level>1) {
            getLevelNodes(root.right, level-1, aux);
            getLevelNodes(root.left, level-1, aux);
        }
        return aux;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        int h = getHeight(root);
        for(int i=1; i<=h; i++) {
            List<Integer> left_right = new ArrayList<>();
            left_right = getLevelNodes(root, i, left_right);
            System.out.println("level " + i + " " + left_right);
            if(i%2==0)
                res.add(left_right);
            else {
                List<Integer> right_left = new ArrayList<>();
                for(int j=left_right.size()-1; j>=0; j--) {
                    right_left.add(left_right.get(j));
                }
                res.add(right_left);
            }
        }
        return res;
    }
}
