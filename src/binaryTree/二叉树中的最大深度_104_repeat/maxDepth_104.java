package binaryTree.二叉树中的最大深度_104_repeat;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class maxDepth_104 {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return getMaxDepth(root, 0, 0, 0);
    }

    private int getMaxDepth(TreeNode root, int leftDepth, int rightDepth, int max) {
        // 构建递归终止条件，是针对单个节点递归的，返回的max会被其父节点的leftDepth1和rightDepth1接受到
        if(root == null) {
            return max;
        }
        // 构建子节点递归参数
        leftDepth ++;
        rightDepth ++;
        // max的值在递归的过程中一路向下传导并且递增
        max = Math.max(leftDepth, rightDepth);

        // 子节点根据递归参数进行递归
        int leftDepth1 = getMaxDepth(root.left, leftDepth, rightDepth, max);
        int rightDepth1 = getMaxDepth(root.right, leftDepth, rightDepth, max);

        // 这个返回值针对左右两个子节点的值合成父子节点的值，并且这个max的值会一直向上传导
        return Math.max(leftDepth1, rightDepth1);
    }
}
