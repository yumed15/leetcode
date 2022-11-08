package trees;

import java.util.ArrayList;
import java.util.List;


public class Traverse {
    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null)
            return res;

        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);

        return res;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        int h = getHeight(root);
        for(int i=0; i<h; i++) {
            List<Integer> aux = new ArrayList<>();
            aux = getLevelNodes(root, i, aux);
            res.add(aux);
        }
        return res;
    }

    public List<Integer> getLevelNodes(TreeNode root, int level, List<Integer> aux) {
        if(root == null) return aux;
        if (level == 1)
        {
            aux.add(root.val);
        }
        if (level > 1) {
            getLevelNodes(root.left, level-1, aux);
            getLevelNodes(root.right, level-1, aux);
        }
        return aux;
    }

    public int getHeight(TreeNode root) {
        if(root == null) return 0;
        return 1+Math.max(getHeight(root.left), getHeight(root.right));
    }

}
