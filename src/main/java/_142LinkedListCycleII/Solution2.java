package _142LinkedListCycleII;

import util.listNode.ListNode;

/**
 * @Description TODO
 * @ClassName Solution2
 * @Author haiyong.huang_sx
 * @Date 2022/6/14 17:05
 * @Version 1.0
 */

/**
 *  假设有环
 *  链表首部到入环口距离为a
 *  快慢指针相遇点为b
 *  b到入环口的距离为c
 *  那么快指针走过的路程为：a + n（b + c）
 *  慢指针走过的距离为 a + b
 *  其中  a + n（b + c） = 2（a + b） ==> a = c + (n - 1) (b + c)
 *  b + c 为环的长度
 *
 */

public class Solution2 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}