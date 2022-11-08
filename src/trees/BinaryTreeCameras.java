package trees;

// 968. Binary Tree Cameras
class BinaryTreeCameras {
    private static final int NOT_COVERED = 0;
    private static final int IS_COVERED = 1;
    private static final int NEEDS_CAMERA = 2;
    private int res;
    public int minCameraCover(TreeNode root) {
        if(dfs(root) == NOT_COVERED) res++;
        return res;
    }
    private int dfs(TreeNode node){
        if(node == null) return IS_COVERED;
        int left = dfs(node.left);
        int right = dfs(node.right);
        if(left == NOT_COVERED || right == NOT_COVERED){
            res++;
            return NEEDS_CAMERA;
        }
        if(left == NEEDS_CAMERA || right == NEEDS_CAMERA) return IS_COVERED;
        return NOT_COVERED;
    }
}
