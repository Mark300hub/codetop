package _023MergekSortedLists;

import util.listNode.ListNode;



/**
 * @Description TODO
 * @ClassName Solution
 * @Author haiyong.huang_sx
 * @Date 2022/6/14 10:42
 * @Version 1.0
 */
// 合并k个有序链表
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) >> 1;
        return mergeLists(mergeKLists(lists, left, mid), mergeKLists(lists, mid + 1, right));
    }

    private ListNode mergeLists(ListNode l1, ListNode l2) {

        ListNode newHead = new ListNode(-1);
        ListNode temp = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 == null ? l2 : l1;
        return newHead.next;
    }
}