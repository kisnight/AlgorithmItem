package binaryTree.二叉树展开为链表_114_repeat;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
解题思路：
1、采用先序遍历将树的各个结点按照一定的顺序保存在集合中
2、遍历集合，构造出符合要求的二叉树
 */

public class flatten_114_repeat2 {
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
        List<TreeNode> treeNodeList = getTreeAllNode(root);
        for(int i = 1; i < treeNodeList.size(); i ++) {
            TreeNode parentNode = treeNodeList.get(i - 1);
            TreeNode curNode = treeNodeList.get(i);
            parentNode.left = null;
            parentNode.right = curNode;
        }
    }

    public static List<TreeNode> getTreeAllNode(TreeNode root) {
        List<TreeNode> treeNodeList = new ArrayList<>();
        Stack<TreeNode> tempStack = new Stack<>();
        tempStack.push(root);
        while (!tempStack.isEmpty()) {
            TreeNode tempNode = tempStack.pop();
            treeNodeList.add(tempNode);
            if(tempNode.right != null) {
                tempStack.push(tempNode.right);
            }

            if(tempNode.left != null) {
                tempStack.push(tempNode.left);
            }
        }
        return treeNodeList;
    }
}
