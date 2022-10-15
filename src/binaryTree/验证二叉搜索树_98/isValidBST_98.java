package binaryTree.验证二叉搜索树_98;

import java.util.Stack;

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

public class isValidBST_98 {
    private static TreeNode root;

    public void getRootTree() {
        TreeNode treeNode1 = new TreeNode(1, null, null);
        TreeNode treeNode3 = new TreeNode(3, null, null);
        TreeNode treeNode6 = new TreeNode(6, null, null);
        TreeNode treeNode4 = new TreeNode(4, treeNode3, treeNode6);
        TreeNode treeNode5 = new TreeNode(5, treeNode1, treeNode4);
        root = treeNode5;
    }
    public static void main(String[] args) {
        isValidBST_98 a = new isValidBST_98();
        a.getRootTree();
        System.out.println(a.isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        Integer preValue = null;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || node != null) {
            //中序遍历,这里中序遍历比较巧妙
            while(node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            if(preValue == null) {
                preValue = node.val;
            }else if(preValue >= node.val) {
                return false;
            }
            preValue = node.val;
            node = node.right;
        }
        return true;
    }
}
