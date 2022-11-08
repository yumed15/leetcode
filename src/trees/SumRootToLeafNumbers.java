package trees;

public class SumRootToLeafNumbers {
    int sum = 0;

    void helper(TreeNode root, int val) {

        if(root == null) return;

        if(root.left == null && root.right == null) {
            sum+=val*10+root.val;
            return;
        }

        helper(root.left, val*10+root.val);
        helper(root.right, val*10+root.val);
    }

    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }
}
