package tech.qijin.study.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * [102. 二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/) 🔥🔥
 */
public class Solution102 {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        dfs(root, 0);
        return ans;
    }
    private void dfs(TreeNode root, int depth){
        if (root == null) return;
        if (ans.size() == depth){
            List<Integer> t = new ArrayList<>();
            t.add(root.val);
            ans.add(t);
        }else{
            ans.get(depth).add(root.val);
        }
        depth++;
        dfs(root.left, depth);
        dfs(root.right, depth);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode p1 = new TreeNode(9);
        TreeNode p2 = new TreeNode(20);
        TreeNode p3 = new TreeNode(15);
        TreeNode p4 = new TreeNode(7);
        root.left = p1;
        root.right = p2;
        p2.left = p3;
        p2.right = p4;
        Solution102 solution102 = new Solution102();
        for (List<Integer> level : solution102.levelOrder(root)) {
            System.out.println(level);
        }
    }
}
