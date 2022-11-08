package trees;

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {

        TreeNode left = null;
        TreeNode right = null;

        return isValidBST(root, left, right);
    }

    public boolean isValidBST(TreeNode root, TreeNode left, TreeNode right){
        if(root==null){
            return true;
        }

        if(left!=null && left.val>=root.val){
            return false;
        }

        if(right!=null && right.val<=root.val){
            return false;
        }

        return isValidBST(root.left, left, root) && isValidBST(root.right, root, right);
    }

    // ------------------ METHOD 2 ------------------------
//    public boolean isValidBST(TreeNode root) {
//        return isValidBST(root, null, null);
//    }
//
//    public boolean isValidBST(TreeNode x, TreeNode min, TreeNode max) {
//        if (x == null) return true;
//        if (max != null && x.val >= max.val) return false;
//        if (min != null && x.val <= min.val) return false;
//        return isValidBST(x.left, min, x) && isValidBST(x.right, x ,max);
//    }
}
