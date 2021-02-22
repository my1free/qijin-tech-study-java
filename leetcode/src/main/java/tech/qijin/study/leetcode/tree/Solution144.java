package tech.qijin.study.leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * [144. 二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/) 🔥🔥
 */
public class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if (root == null) return ans;
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode tn = root;
        stack.push(tn);
        while (!stack.isEmpty()) {
            tn = stack.pop();
            ans.add(tn.val);
            if (tn.right != null) stack.push(tn.right);
            if (tn.left != null) stack.push(tn.left);
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
        Solution144 solution144 = new Solution144();
        for (Integer a : solution144.preorderTraversal(root)) {
            System.out.println(a);
        }
    }
}
