package binaryTree.二叉树中的最大路径和_124_repeat;

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
/*
 解题思路：
    1、针对一个二叉树单元，a 是艮节点，与上层的父节点相连（如果有的话）
    2、b和c是a的左右子节点，与其各子节点中路径最大值的节点相连
    3、因此所有可能的路径情况：
    【左中右】 b+a+c
    【左】b+a
    【右】a+c
 */
public class maxPathSum_124 {
    // 将最大路径和设置为全局变量，便于每次递归的时候可以进行更新
    int maxPathSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMaxPathSum(root);
        return maxPathSum;
    }

    private int getMaxPathSum(TreeNode root) {
        // 1、递归终止条件
        if(root == null) {
            return 0;
        }
        // 2、构建递归的参数

        // 3、子节点根据递归参数进行递归
        // 这里子树返回值至少是0，是因为如果是负数的话路径可以不需要左右子节点，所在的根节点也可以构成一个路径
        int leftValue = Math.max(0, getMaxPathSum(root.left));
        int rightValue = Math.max(0,getMaxPathSum(root.right));

        // 返回当前节点与其左右子节点的合并值
        int leftAndRootSum = leftValue + root.val;
        int rightAndRootSum = rightValue + root.val;
        int leftRightAndRootSum = leftValue + rightValue + root.val;

        // 基于现在的根节点和它的左右两个子节点得出这三个节点相加情况的最大值
        int maxSumOfPathOfUnit = Math.max(leftRightAndRootSum, Math.max(leftAndRootSum, rightAndRootSum));
        /*
        更新全局变量的最大路径和，和以前的maxPathSum做对比是因为现在的maxSumOfPathOfUnit只是
        基于现在的根节点和它的左右两个子节点得出这三个节点相加情况的最大值，而该根节点有可能为负数的，
        因此maxSumOfPathOfUnit这很有可能比原来的maxPathSum都小，所以要取两者之间的最大值；
         */
        maxPathSum = Math.max(maxPathSum, maxSumOfPathOfUnit);
        /*
          该节点返回的路径最大的值应该是该节点和子节点加起来最大的那个路径,因为在判断最大路径后，
          只能选择一个分支路径，要么是左子树，要么是右子树；
         */
        int rootRetValue = Math.max(leftAndRootSum, rightAndRootSum);
        return rootRetValue;

    }
}
