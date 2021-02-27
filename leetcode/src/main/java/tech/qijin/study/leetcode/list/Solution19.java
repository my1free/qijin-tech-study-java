package tech.qijin.study.leetcode.list;

/**
 * [19. 删除链表的倒数第 N 个结点](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/) 🔥🔥
 */
public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head;
        ListNode p = head;
        ListNode pn = head;
        while (--n > 0) {
            pn = pn.next;
            if (pn == null) return null;
        }
        if (pn.next == null) {
            head = head.next;
            return head;
        }
        while (pn.next != null) {
            pn = pn.next;
            pre = p;
            p = p.next;
        }
        pre.next = p.next;
        p.next = null;
        return head;
    }

    public static void main(String[] args) {
        // 输入：head = [1,2,3,4,5], n = 2
        // 输出：[1,2,3,5]
        Solution19 solution19 = new Solution19();
        {
            ListNode l1 = new ListNode(1);
            ListNode l2 = new ListNode(2);
            ListNode l3 = new ListNode(3);
            ListNode l4 = new ListNode(4);
            ListNode l5 = new ListNode(5);
            l1.next = l2;
            l2.next = l3;
            l3.next = l4;
            l4.next = l5;
            ListNode head = solution19.removeNthFromEnd(l1, 2);
            while (head != null) {
                System.out.println(head.val);
                head = head.next;
            }
        }

        {
            ListNode l1 = new ListNode(1);
            ListNode head = solution19.removeNthFromEnd(l1, 1);
            while (head != null) {
                System.out.println(head.val);
                head = head.next;
            }
        }

        {
            ListNode l1 = new ListNode(1);
            ListNode l2 = new ListNode(2);
            l1.next = l2;
            ListNode head = solution19.removeNthFromEnd(l1, 1);
            while (head != null) {
                System.out.println(head.val);
                head = head.next;
            }
        }
    }
}
