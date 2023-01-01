package binaryTree.二叉树中的最大路径和_124_repeat;

/*
 解题思路：
    1、针对一个二叉树单元，a 是艮节点，与上层的父节点相连（如果有的话）
    2、b和c是a的左右子节点，与其各子节点中路径最大值的节点相连
    3、因此所有可能的路径情况：
    【左中右】 b+a+c
    【左】b+a
    【右】a+c
 */
public class maxPathSum_124_repeat {
    // 将最大路径和设置为全局变量，便于每次递归的时候可以进行更新
    int maxPathSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMaxPathSum(root);
        return maxPathSum;
    }

    private int getMaxPathSum(TreeNode root) {
        // 构建递归终止条件
        if(root == null) {
            return 0;
        }
        // 构建传入的参数
        int leftVal = Math.max(0, getMaxPathSum(root.left));
        int rightVal = Math.max(0, getMaxPathSum(root.right));

        // 计算三种情况下的路径和
        int leftRootSum = leftVal + root.val;
        int rightRootSum = rightVal + root.val;
        int leftRootRightSum =  leftRootSum + rightVal;

        // 求出三种路径和的最大值
        int maxSumOfPathOfUnit = Math.max(leftRootRightSum, Math.max(rightRootSum, leftRootRightSum));

        // 针对每个路径单元，更新全局变量中的最大路径和
        if(maxSumOfPathOfUnit > maxPathSum) {
            maxPathSum = maxSumOfPathOfUnit;
        }
        // 构建
        int retValOfPathUnit = Math.max(leftRootSum, rightRootSum);
        return retValOfPathUnit;
    }
}
