package _160IntersectionofTwoLinkedLists;

import util.listNode.ListNode;

/**
 * @author : i.Boss
 * @program : codetop
 * @description :
 * @create : 2022-06-12 12:15
 **/
// 相交链表
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }
}