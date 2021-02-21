package tech.qijin.study.leetcode.list;

import java.util.List;

public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode same = findSame(head);
        if (same == null) return null;
        ListNode p = head;
        while (p != same){
            p = p.next;
            same = same.next;
        }
        return p;
    }

    private ListNode findSame(ListNode head) {
        ListNode slow = head; ListNode fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast != null && slow == fast) return slow;
        }
        return null;
    }

    public static void main(String[] args) {
        // head = [3,2,0,-4], pos = 1
        ListNode p1 = new ListNode(-1);
        ListNode p2 = new ListNode(-7);
        ListNode p3 = new ListNode(7);
        ListNode p4 = new ListNode(-4);
        ListNode p5 = new ListNode(19);
        ListNode p6 = new ListNode(6);
        ListNode p7 = new ListNode(-9);
        ListNode p8 = new ListNode(-5);
        ListNode p9 = new ListNode(-2);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        p5.next = p6;
        p6.next = p7;
        p7.next = p8;
        p8.next = p9;
        p9.next = p8;
        ListNode head = p1;
        Solution142 solution142 = new Solution142();
        System.out.println(solution142.detectCycle(head).val);
    }
}
