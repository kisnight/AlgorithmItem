package binaryTree.二叉树的中序遍历_94;

import java.util.ArrayList;
import java.util.List;


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

// 如果节点不为空，遍历左子树，直到叶子结点，加入结果集，再遍历该节点的右子树
public class inorderTraversal_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        minorder(root, res);
        return res;
    }

    private void minorder(TreeNode root, List<Integer> res) {
        if(root == null) {
            return;
        }
        minorder(root.left, res);
        res.add(root.val);
        minorder(root.right,res);
    }

}
