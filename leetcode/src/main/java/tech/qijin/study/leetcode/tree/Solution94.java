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
        inorder(root, ans);
        return ans;
    }

    private void inorder(TreeNode root, List<Integer> ans) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        if (root == null) return;
        stack.push(root);
        while (stack.size() != 0) {
            while (stack.peek().left != null) {
                stack.push(stack.peek().left);
            }
            ans.add(stack.pop().val);
            if (stack.size() != 0 && stack.peek().right != null) {
                stack.push(stack.peek().right);
            }
        }

    }
}
