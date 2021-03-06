package tech.qijin.study.leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * [94. 二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/) 🔥🔥
 */
public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if (root == null) return ans;
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode tn = root;
        while (tn != null || !stack.isEmpty()) {
            while (tn != null) {
                stack.push(tn);
                tn = tn.left;
            }
            tn = stack.pop();
            ans.add(tn.val);
            tn = tn.right;
        }
        return ans;
    }

    public static void main(String[] args) {
        // root = [1,null,2,3]
        TreeNode root = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        root.right = t2;
        t2.left = t3;
        Solution94 solution94 = new Solution94();
        for (Integer a : solution94.inorderTraversal(root)) {
            System.out.println(a);
        }
    }
}
