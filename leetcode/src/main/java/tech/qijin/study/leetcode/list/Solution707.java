package tech.qijin.study.leetcode.list;

import java.util.LinkedList;

/**
 * [707. 设计链表](https://leetcode-cn.com/problems/design-linked-list/) 🔥🔥
 */
public class Solution707 {
    static class LinkedNode{
        int val;
        LinkedNode next;
        LinkedNode prev;

        public LinkedNode(int val) {
            this.val = val;
        }
    }
    static class MyLinkedList {
        LinkedNode head;
        LinkedNode tail;
        /** Initialize your data structure here. */
        public MyLinkedList() {

        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            if (head == null) {
                return -1;
            }
            LinkedNode p = head;
            while (index-- > 0 && p != null) {
                p = p.next;
            }
            return p == null ? -1 : p.val;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            if (head == null) {
                head = new LinkedNode(val);
                tail = head;
            }else {
                LinkedNode p = new LinkedNode(val);
                p.next = head;
                head.prev = p;
                head = p;
            }
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            if (tail == null) {
                tail = new LinkedNode(val);
                head = tail;
            }else{
                LinkedNode p = new LinkedNode(val);
                tail.next = p;
                p.prev = tail;
                tail = p;
            }
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if (head == null) return;
            LinkedNode p = head;
            while (index-- > 0 && p != null) {
                p = p.next;
            }
            if (index == 0 && p == null) {
                LinkedNode t = new LinkedNode(val);
                tail.next = t;
                t.prev = tail;
                tail = t;
            } else if (p == null) {
                return;
            }else {
                LinkedNode t = new LinkedNode(val);
                t.prev = p.prev;
                p.prev = t;
                t.next = p;
            }
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if (head == null) return;
        }
    }

    public static void main(String[] args) {
        Solution707.MyLinkedList myLinkedList = new Solution707.MyLinkedList();
    }
}
