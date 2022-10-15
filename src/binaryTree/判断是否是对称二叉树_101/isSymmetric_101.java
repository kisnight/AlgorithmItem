package binaryTree.判断是否是对称二叉树_101;


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

public class isSymmetric_101 {

    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return dfs(root.left, root.right);
    }

    /*
        // 1、确定递归函数的传参
     */
    private boolean dfs(TreeNode leftNode, TreeNode rightNode) {

        /*
        2、确定终止条件
         (1)左右都为空，对称，返回true
         (2)左节点为空，右节点不为空，不对称，return false
         (3)左不为空，右为空，不对称 return false
         (4)左右都不为空，比较节点数值，不相同就return false
         */
        if(leftNode == null && rightNode == null) {
            return true;
        }
        if(leftNode == null && rightNode != null) {
            return false;
        }

        if(leftNode != null && rightNode == null) {
            return false;
        }

        // 左边节点的值与右边节点的值不相同的话也不是对称的
        if(leftNode.val != rightNode.val) {
            return false;
        }

        /*
        3、确定单层递归的逻辑
        (1)比较二叉树外侧是否对称：传入的是左节点的左孩子，右节点的右孩子。
        (2)比较内测是否对称，传入左节点的右孩子，右节点的左孩子。
        (3)如果左右都对称就返回true ，有一侧不对称就返回false 。
         */

        // 左子树：左边节点 右子树：右边节点
        boolean outSideComp = dfs(leftNode.left, rightNode.right);
        // 左子树：右边节点 右子树：左边节点
        boolean insideComp = dfs(leftNode.right, rightNode.left);
        // 左子树和右子树都是对称的，说明这个结点所对应的二叉树是对称的
        return outSideComp && insideComp;

    }
}
