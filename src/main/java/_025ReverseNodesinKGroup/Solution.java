package _025ReverseNodesinKGroup;

import util.listNode.ListNode;

/**
 * @author : i.Boss
 * @program : codetop
 * @description :
 * @create : 2022-06-04 20:20
 **/
// k个一组反转链表
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) {
            return head;
        }

        ListNode preHead = new ListNode(-1, head);
        ListNode curHead = preHead;
        ListNode fast = preHead.next;

        while (fast != null) {
            int n = k;
            while (fast != null && n > 0) {
                fast = fast.next;
                n--;
            }
            if (fast == null && n != 0) {
                break;// 结束
            }
            curHead = reverseList(curHead, fast);
        }

        return preHead.next;
    }

    /*
     * @Description //TODO
     * @Param preHead: 待反转链表的前一个节点
     * @param end: 带反转链表的下一个节点
     * @return : util.listNode.ListNode 反转之后链表的尾结点
     **/
    private ListNode reverseList(ListNode preHead, ListNode end) {
        ListNode cur = preHead.next;
        while (cur != end && cur.next != end) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = preHead.next;
            preHead.next = temp;
        }
        return cur;
    }
}