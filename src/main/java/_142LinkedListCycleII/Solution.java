package _142LinkedListCycleII;

import util.listNode.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description TODO
 * @ClassName Solution
 * @Author haiyong.huang_sx
 * @Date 2022/6/14 11:18
 * @Version 1.0
 */
// 获取环形链表的入环点
public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }
}