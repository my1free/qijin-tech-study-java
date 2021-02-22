package tech.qijin.study.leetcode.tree;

/**
 * [236. 二叉树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/) 🔥🔥
 */
public class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if (p == root || q == root) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return (left != null && right != null) ? root : (left != null ? left : right);
    }

    public static void main(String[] args) {
        // root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
        TreeNode root = new TreeNode(3);
        TreeNode p5 = new TreeNode(5);
        TreeNode p1 = new TreeNode(1);
        TreeNode p6 = new TreeNode(6);
        TreeNode p2 = new TreeNode(2);
        TreeNode p0 = new TreeNode(0);
        TreeNode p8 = new TreeNode(8);
        TreeNode p7 = new TreeNode(7);
        TreeNode p4 = new TreeNode(4);
        root.left = p5;
        root.right = p1;
        p5.left = p6;
        p5.right = p2;
        p1.left = p0;
        p1.right = p8;
        p2.left = p7;
        p2.right = p4;
        Solution236 solution236 = new Solution236();
        System.out.println(solution236.lowestCommonAncestor(root, p5, p1).val == 3);
    }
}
