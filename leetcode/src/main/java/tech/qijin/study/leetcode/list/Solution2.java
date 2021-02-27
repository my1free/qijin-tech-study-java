package tech.qijin.study.leetcode.list;

import tech.qijin.study.leetcode.tree.TreeNode;

public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode head = null;
        ListNode ans = null;
        if (p1 == null) return l2;
        if (p2 == null) return l1;
        int delta = 0;
        while (p1 != null || p2 != null) {
            int sum = (p1 == null ? 0 : p1.val) + (p2 == null ? 0 : p2.val) + delta;
            ListNode node = new ListNode(sum % 10);
            delta = sum / 10;
            if (ans == null){
                ans = node;
                head = ans;
            }else{
                ans.next = node;
                ans = node;
            }
            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        }
        if (delta != 0) {
            ans.next = new ListNode(delta);
        }
        return head;
    }

    public static void main(String[] args) {
        // 输入：l1 = [2,4,3], l2 = [5,6,4]
        // 输出：[7,0,8]
        // 解释：342 + 465 = 807.
        ListNode l1 = new ListNode(2);
        ListNode l14 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        l1.next = l14;
        l14.next = l13;

        ListNode l2 = new ListNode(5);
        ListNode l26 = new ListNode(6);
        ListNode l24 = new ListNode(4);
        l2.next = l26;
        l26.next = l24;

        Solution2 solution2 = new Solution2();
        ListNode ans = solution2.addTwoNumbers(l1, l2);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
