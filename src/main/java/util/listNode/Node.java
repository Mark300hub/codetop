package util.listNode;

/**
 * @author : Mr.Boss
 * @program : 剑指offer
 * @description :
 * @create : 2021-10-30 15:17
 **/
public class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}