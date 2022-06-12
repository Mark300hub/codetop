package _141LinkedListCycle;

import util.listNode.ListNode;

/**
 * @author : i.Boss
 * @program : codetop
 * @description :
 * @create : 2022-06-07 22:28
 **/
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = new ListNode(-1, head);
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}