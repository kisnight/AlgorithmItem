package binaryTree.二叉树展开为链表_114;


import java.util.LinkedList;
import java.util.Stack;

/*
解题思路：
1、采用先序遍历将树的各个结点按照一定的顺序保存在集合中
2、遍历集合，构造出符合要求的二叉树
 */
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

public class flatten_114 {
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

        LinkedList<TreeNode> res = getAllNode(root);
        // 遍历已经构建完成的中间节点，注意是从i = 1开始遍历，因为在遍历的时候需要找出所在节点的父节点，建立关系
        for(int i = 1; i < res.size(); i ++) {
            // 求出父节点
            TreeNode pre = res.get(i - 1);
            // 求出目前的节点
            TreeNode cur = res.get(i);
            // 父节点的左子节点为null；
            pre.left = null;
            // 父节点的右子节点为目前所在的节点
            pre.right = cur;
        }
    }

    public static LinkedList<TreeNode> getAllNode(TreeNode root){
        LinkedList<TreeNode> tempNodes =new LinkedList<TreeNode>();
        if(root==null){
            return tempNodes;
        }
        Stack<TreeNode> stack = new Stack<>();
        // 首先push 根节点（node1）
        stack.push(root);
        while(!stack.isEmpty()) {
            // 循环的时候将每一个出栈的节点当做根节点
            TreeNode tempNode = stack.pop();
            // 每次循环一次的时候只会添加上述的根节点，同时栈内删除
            tempNodes.add(tempNode);
            // 使用栈优先添加该根节点右边子节点，方便在下一轮循环的时候左边子节点优先被弹出
            if(tempNode.right != null) {
                stack.push(tempNode.right);
            }

            if(tempNode.left != null) {
                stack.push(tempNode.left);
            }
        }
        return tempNodes;
    }
}
