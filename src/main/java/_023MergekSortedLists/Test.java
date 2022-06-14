package _023MergekSortedLists;

import util.listNode.ListNode;

/**
 * @Description TODO
 * @ClassName Test
 * @Author haiyong.huang_sx
 * @Date 2022/6/14 11:02
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(-1);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(11);
        node1.next = node2; node2.next = node3;
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(10);
        node4.next = node5;

        ListNode[] lists = {null, node1, null, node4};
        Solution solution = new Solution();
        solution.mergeKLists(lists);
    }
}