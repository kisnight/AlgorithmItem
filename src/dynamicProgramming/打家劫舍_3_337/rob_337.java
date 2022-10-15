package dynamicProgramming.打家劫舍_3_337;

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
public class rob_337 {
    public int rob(TreeNode root) {
        /*
        res 二维数组   res 0 res1
        res[0] 不抢劫当前节点的最大值
        res[1] 抢劫当前节点的最大值
         */
        int[] res = dp(root);
        return Math.max(res[0],res[1]);
    }

    public int[] dp(TreeNode root) {
        if(root == null) {
            return new int[]{0,0};
        }

        int [] left = dp(root.left);
        int [] right = dp(root.right);
        int not_rob = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        int rob = root.val + left[0] + right[0];
        return new int[]{not_rob,rob};
    }
}
