package tech.qijin.study.leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * [145. 二叉树的后序遍历](https://leetcode-cn.com/problems/binary-tree-postorder-traversal/) 🔥🔥
 */
public class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if (root == null) return ans;
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode tn = root;
        stack.push(tn);
        TreeNode pre = null;
        while (!stack.isEmpty()){
            tn = stack.pop();
            if ((pre != null && pre == tn.left) || (pre != null && pre == tn.right) || (tn.left == null && tn.right == null)){
                ans.add(tn.val);
                pre = tn;
            }else{
                stack.push(tn);
                if (tn.right != null) stack.push(tn.right);
                if (tn.left != null) stack.push(tn.left);
            }
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
        Solution145 solution145 = new Solution145();
        for (Integer a : solution145.postorderTraversal(root)) {
            System.out.println(a);
        }
    }
}
