package binaryTree.二叉树展开为链表_114_repeat;


import java.util.LinkedList;
import java.util.Stack;

public class flatten_114_repeat {
    private static TreeNode root;

    public void main(String[] args) {
        getRootTree();
        flatten(root);
        System.out.println("success");
    }

    public static void getRootTree() {
        TreeNode treeNode3 = new TreeNode(3, null, null);
        TreeNode treeNode4 = new TreeNode(4, null, null);
        TreeNode treeNode6 = new TreeNode(6, null, null);
        TreeNode treeNode2 = new TreeNode(2,treeNode3 ,treeNode4);
        TreeNode treeNode5 = new TreeNode(5,null ,treeNode6);
        TreeNode treeNode1 = new TreeNode(1,treeNode2 ,treeNode5);
        root = treeNode1;
    }

    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        LinkedList<TreeNode> nodeList = getAllNode(root);

        for(int i = 1; i < nodeList.size(); i ++) {
            TreeNode parentNode = nodeList.get(i -1);
            TreeNode currentNode = nodeList.get(i);
            parentNode.left = null;
            parentNode.right = currentNode;
        }
    }

    public static LinkedList<TreeNode> getAllNode(TreeNode root){
        LinkedList<TreeNode> tempNodeList = new LinkedList<>();
        if(root == null) {
            return tempNodeList;
        }

        Stack<TreeNode> tempStack = new Stack<>();
        tempStack.add(root);
        while (!tempStack.isEmpty()) {
            TreeNode node = tempStack.pop();
            tempNodeList.add(node);

            if(node.right != null) {
                tempStack.push(node.right);
            }

            if(node.left != null) {
                tempStack.push(node.left);
            }

        }

        return tempNodeList;
    }
}
