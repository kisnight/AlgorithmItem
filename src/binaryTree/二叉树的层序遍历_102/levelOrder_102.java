package binaryTree.二叉树的层序遍历_102;
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


public class levelOrder_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        /*
            该List是为了存储二叉树中的每一层的节点，
            每一次的whle循环都会将这一层的节点移除并且将下一层的子节点重新加载进来
         */
        List<TreeNode> singleLevelNodeList = new ArrayList<>();
        if(root == null) {
            return res;
        }
        // 开始阶段第一层只有root一个节点，加载近进来
        singleLevelNodeList.add(root);

        /*
            每一次的whle循环都会将这一层的节点移除并且将下一层的子节点重新加载进来,
            直至singleLevelNodeList为空
         */
        while (!singleLevelNodeList.isEmpty()) {
            // 获取到每一层的节点数量
            int singleLevelNodeNums = singleLevelNodeList.size();
            // 用于统计每一层的节点的值
            List<Integer> singleLevelNodeValues = new ArrayList<>();
            // 对每一层的节点进行遍历，
            for (int i = 0; i < singleLevelNodeNums; i ++) {
                // 移除singleLevelNodeList最前面进入的节点
                TreeNode node = singleLevelNodeList.remove(0);
                // 添加被移除的节点的值
                singleLevelNodeValues.add(node.val);

                // 针对被移除的节点，向后添加它的左节点以便于下一次的while循环操作
                if(node.left != null) {
                    singleLevelNodeList.add(node.left);
                }

                // 针对被移除的节点，向后添加它的右节点以便于下一次的while循环操作
                if(node.right != null) {
                    singleLevelNodeList.add(node.right);
                }
            }
            // 每一层的节点值的统计添加
            res.add(singleLevelNodeValues);
        }

        return res;
    }
}
