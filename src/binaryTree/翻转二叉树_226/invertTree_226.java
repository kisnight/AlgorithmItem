package binaryTree.翻转二叉树_226;

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
public class invertTree_226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        invert(root);
        return root;
    }

    private void invert(TreeNode root) {
        // 1、确定递归函数的参数和返回值
        // 2、递归终止条件
        if(root == null) {
            return;
        }
        /*
            因为是先前序遍历，所以先进行交换左右孩子节点，然后反转左子树，反转右子树。
         */
        /// 3、确定单层递归的逻辑
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        // 子节点根据递归参数进行递归
        invert(root.left);
        invert(root.right);
    }
}
