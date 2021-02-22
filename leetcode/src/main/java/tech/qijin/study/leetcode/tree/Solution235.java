package tech.qijin.study.leetcode.tree;

/**
 * [235. 二叉搜索树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/) 🔥
 */
public class Solution235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if ((p.val < root.val && q.val > root.val) || (p.val > root.val && q.val < root.val)) return root;
        if (root == p) return p;
        if (root == q) return q;
        if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        return null;
    }

    public static void main(String[] args) {
        Solution235 solution235 = new Solution235();
        // root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
        TreeNode root = new TreeNode(6);
        TreeNode p2 = new TreeNode(2);
        TreeNode p8 = new TreeNode(8);
        TreeNode p0 = new TreeNode(0);
        TreeNode p4 = new TreeNode(4);
        TreeNode p7 = new TreeNode(7);
        TreeNode p9 = new TreeNode(9);
        TreeNode p3 = new TreeNode(3);
        TreeNode p5 = new TreeNode(5);
        root.left = p2;
        root.right = p8;
        p2.left = p0;
        p2.right = p4;
        p4.left = p3;
        p4.right = p5;
        p8.left = p7;
        p8.right = p9;
        System.out.println(solution235.lowestCommonAncestor(root, p2, p8).val);
    }
}
