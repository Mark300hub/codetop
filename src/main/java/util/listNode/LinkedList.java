package util.listNode;

/**
 * @author : Mr.Boss
 * @program : LeetCode
 * @description :
 * @create : 2021-05-24 12:44
 **/
public class LinkedList {
    public ListNode head;

    public LinkedList() {
    }

    public LinkedList(ListNode head) {
        this.head = head;
    }

    public void add(ListNode node) {
        if(head == null) {
            head = node;
            return;
        }
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public void showList() {
        if(head == null) {
            System.out.println("链表为空");
            return;
        }
        ListNode temp = head;
        while(null != temp) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public int getLength() {
        if(this.head == null) {
            return 0;
        }
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }
}