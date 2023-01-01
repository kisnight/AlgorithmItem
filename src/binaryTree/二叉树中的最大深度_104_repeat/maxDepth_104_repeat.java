package binaryTree.二叉树中的最大深度_104_repeat;


public class maxDepth_104_repeat {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return getMaxDepth(root, 0, 0, 0);

    }

    public int getMaxDepth(TreeNode root, int leftDepth, int rightDepth, int max) {
        // 构建递归返回终止条件
        if(root == null) {
            return max;
        }

        // 构建递归参数
        leftDepth ++;
        rightDepth ++;
        // 求出左右子节点的最大值
        max = Math.max(leftDepth, rightDepth);

        // 进行递归
        int leftNodeDepth = getMaxDepth(root.left, leftDepth, rightDepth, max);
        int rightNodeDepth = getMaxDepth(root.right, leftDepth, rightDepth, max);

        // 返回左右两颗子树高度的最大值
        return Math.max(leftNodeDepth, rightNodeDepth);
    }
}
