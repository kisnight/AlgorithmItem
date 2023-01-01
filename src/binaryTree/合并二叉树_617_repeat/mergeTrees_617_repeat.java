package binaryTree.合并二叉树_617_repeat;


public class mergeTrees_617_repeat {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 != null && root2 == null) {
            return root1;
        }

        if(root1 == null && root2 != null) {
            return root2;
        }

        if(root1 == null && root2 == null) {
            return null;
        }

        return dfs(root1, root2);
    }

    private TreeNode dfs(TreeNode root1, TreeNode root2) {
        // 递归终止条件
        if(root1 == null && root2 == null) {
            return null;
        }
        /*
            构建在递归中需要传入的参数
            (1)合并根节点
            (2)合并左边节点
            (3)合并右边节点
         */
        // 合并根节点
        TreeNode mergeNode = new TreeNode();
        int root1Val = root1 == null ? 0 : root1.val;
        int root2Val = root2 == null ? 0 : root2.val;
        mergeNode.val = root1Val + root2Val;

        // 求出两个节点的左节点
        TreeNode root1LeftNode = root1 == null ? null : root1.left;
        TreeNode root2LeftNode = root2 == null ? null : root2.left;

        // 求出两个节点的右节点
        TreeNode root1RightNode = root1 == null ? null : root1.right;
        TreeNode root2RightNode = root2 == null ? null : root2.right;

        // 构建递归
        mergeNode.left = dfs(root1LeftNode, root2LeftNode);
        mergeNode.right = dfs(root1RightNode, root2RightNode);

        return mergeNode;
    }
}
