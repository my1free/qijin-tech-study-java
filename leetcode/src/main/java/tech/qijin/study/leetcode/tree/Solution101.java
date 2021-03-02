package tech.qijin.study.leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * [101. 对称二叉树](https://leetcode-cn.com/problems/symmetric-tree/) 🔥
 */
public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;
        return false;
    }

    public static void main(String[] args) {
        Solution101 solution101 = new Solution101();
        // [1,2,2,3,4,4,3]
        {
            TreeNode root = new TreeNode(1);
            TreeNode n2 = new TreeNode(2);
            TreeNode n22 = new TreeNode(2);
            TreeNode n3 = new TreeNode(3);
            TreeNode n4 = new TreeNode(4);
            TreeNode n33 = new TreeNode(3);
            TreeNode n44 = new TreeNode(4);
            root.left = n2;
            root.right = n22;
            n2.left = n3;
            n2.right = n4;
            n22.left = n33;
            n33.right = n44;
            System.out.println(solution101.isSymmetric(root));
        }
        {
            TreeNode root = new TreeNode(1);
            TreeNode n2 = new TreeNode(2);
            TreeNode n22 = new TreeNode(2);
            TreeNode n3 = new TreeNode(3);
            TreeNode n4 = new TreeNode(4);
            TreeNode n33 = new TreeNode(3);
            TreeNode n44 = new TreeNode(4);
            root.left = n2;
            root.right = n22;
            n2.right = n3;
            n22.right = n33;
            System.out.println(solution101.isSymmetric(root));
        }
    }
}
