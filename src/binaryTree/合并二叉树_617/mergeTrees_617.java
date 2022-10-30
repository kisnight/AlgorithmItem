package binaryTree.合并二叉树_617;

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

public class mergeTrees_617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 != null) {
            return root2;
        }
        if(root1 != null && root2 == null) {
            return root1;
        }

        if(root1 == null && root2 == null) {
            return null;
        }
        // 采用dfs算法
        return dfs(root1, root2);
    }

    private TreeNode dfs(TreeNode root1, TreeNode root2) {
        // 1、构建递归的参数
        // 2、构建递归的出口
        if(root1 == null && root2 == null) {
            return null;
        }
        // 3、构建递归中要做的事情
        // 先合并根节点
        TreeNode mergeNode = new TreeNode();
        int root1Val = root1 == null ? 0 : root1.val;
        int root2Val = root2 == null ? 0 : root2.val;
        // 这里是合并操作，也包括对左子树和右子树的递归合并
        mergeNode.val = root1Val + root2Val;

        // 获取到两颗树的左子节点
        TreeNode root1LeftNode = root1 == null ? null : root1.left;
        TreeNode root2LeftNode = root2 == null ? null : root2.left;

        // 获取到两颗树的右子节点
        TreeNode root1RightNode = root1 == null ? null : root1.right;
        TreeNode root2RightNode = root2 == null ? null : root2.right;

        // 递归合并左右子树，注意这里的mergeNode.left表明mergeNode的左子树可以由dfs求出
        mergeNode.left = dfs(root1LeftNode, root2LeftNode);
        mergeNode.right = dfs(root1RightNode, root2RightNode);

        return mergeNode;
    }

}
