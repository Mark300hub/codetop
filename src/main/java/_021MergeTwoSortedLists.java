import util.listNode.ListNode;

/**
 * @author : i.Boss
 * @program : codetop
 * @description :
 * @create : 2022-06-06 21:07
 **/
// 合并两个有序链表
public class _021MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}