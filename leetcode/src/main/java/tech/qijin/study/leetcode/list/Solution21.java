package tech.qijin.study.leetcode.list;

/**
 * [21. 合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists/) 🔥
 */
public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode p1 = l1.val > l2.val ? l2 : l1;
        ListNode p2 = p1 == l1 ? l2 : l1;
        while (p1 != null && p2 != null) {
            ListNode pre = p1;
            while (p1 != null && p2.val >= p1.val){
                pre = p1;
                p1 = p1.next;
            }
            pre.next = p2;
            if (p1 != null) {
                while (p2 != null && p2.val < p1.val) {
                    pre = p2;
                    p2 = p2.next;
                }
                pre.next = p1;
            }
        }
        return l1.val > l2.val ? l2 : l1;
    }

    public static void main(String[] args) {
        // 输入：l1 = [1,2,4], l2 = [1,3,4]
        // 输出：[1,1,2,3,4,4]
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l14 = new ListNode(4);
//        l11.next = l12;
//        l12.next = l14;
        ListNode l21 = new ListNode(1);
        ListNode l23 = new ListNode(3);
        ListNode l24 = new ListNode(4);
        l21.next = l23;
        l23.next = l24;
        Solution21 solution21 = new Solution21();
        ListNode res = solution21.mergeTwoLists(l12, l11);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
