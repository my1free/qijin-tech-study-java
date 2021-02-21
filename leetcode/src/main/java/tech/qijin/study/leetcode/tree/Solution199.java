package tech.qijin.study.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * [199. 二叉树的右视图](https://leetcode-cn.com/problems/binary-tree-right-side-view/) 🔥🔥
 */
public class Solution199 {
    List<Integer> ans = new ArrayList<Integer>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) return;
        if (ans.size() == depth) {
            ans.add(root.val);
        }else{
            ans.set(depth, root.val);
        }
        depth++;
        dfs(root.left, depth);
        dfs(root.right, depth);
    }

    public static void main(String[] args) {
        Solution199 solution199 = new Solution199();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        System.out.println(solution199.rightSideView(root));
    }
}
