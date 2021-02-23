package tech.qijin.study.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * [958. 二叉树的完全性检验](https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/) 🔥🔥
 */
public class Solution958 {
    public boolean isCompleteTree(TreeNode root) {
        return isCompleteTree1(root);
//        return isCompleteTree2(root);
    }

    /**
     * 广度优先遍历，看null后面是否还有节点
     * @param root
     * @return
     */
    private boolean isCompleteTree1(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) break;
            queue.offer(node.left);
            queue.offer(node.right);
        }
        for (TreeNode n : queue) {
            if (n != null) return false;
        }
        return true;
    }

    /**
     * 给节点编号，看数组size是否等于编号大小
     * @param root
     * @return
     */
    private boolean isCompleteTree2(TreeNode root) {
        List<ANode> nodes = new ArrayList();
        nodes.add(new ANode(root, 1));
        int i = 0;
        while (i < nodes.size()) {
            ANode anode = nodes.get(i++);
            if (anode.node != null) {
                nodes.add(new ANode(anode.node.left, anode.code * 2));
                nodes.add(new ANode(anode.node.right, anode.code * 2 + 1));
            }
        }

        return nodes.get(i - 1).code == nodes.size();
    }


    class ANode {  // Annotated Node
        TreeNode node;
        int code;

        ANode(TreeNode node, int code) {
            this.node = node;
            this.code = code;
        }
    }

    public static void main(String[] args) {
        // 输入：[1,2,3,4,5,6]
        // 输出：true
        {
            TreeNode root = new TreeNode(1);
            TreeNode tn2 = new TreeNode(2);
            TreeNode tn3 = new TreeNode(3);
            TreeNode tn4 = new TreeNode(4);
            TreeNode tn5 = new TreeNode(5);
            TreeNode tn6 = new TreeNode(6);
            root.left = tn2;
            root.right = tn3;
            tn2.left = tn4;
            tn2.right = tn5;
            tn3.left = tn6;
            Solution958 solution958 = new Solution958();
            System.out.println(solution958.isCompleteTree(root));
        }

        // 输入：[1,2,3,4,5,null,7]
        // 输出：false
        {
            TreeNode root = new TreeNode(1);
            TreeNode tn2 = new TreeNode(2);
            TreeNode tn3 = new TreeNode(3);
            TreeNode tn4 = new TreeNode(4);
            TreeNode tn5 = new TreeNode(5);
            TreeNode tn7 = new TreeNode(7);
            root.left = tn2;
            root.right = tn3;
            tn2.left = tn4;
            tn2.right = tn5;
            tn3.right = tn7;
            Solution958 solution958 = new Solution958();
            System.out.println(solution958.isCompleteTree(root));
        }
    }
}
