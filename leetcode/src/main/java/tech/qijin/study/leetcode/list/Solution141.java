package tech.qijin.study.leetcode.list;

/**
 * [141. 环形链表](https://leetcode-cn.com/problems/linked-list-cycle/) 🔥
 */
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (slow != null && fast != null && fast.next != null) {
            if (slow.val == fast.val) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public static void main(String[] args) {
        // head = [3,2,0,-4], pos = 1
        ListNode p = new ListNode(3);
        ListNode head = p;
        p.next = new ListNode(2);
        p = p.next;
        p.next = new ListNode(0);
        p = p.next;
        p.next = new ListNode(-4);
        p = p.next;
        p.next = head.next;
        Solution141 solution141 = new Solution141();
        System.out.println(solution141.hasCycle(head));
    }
}
