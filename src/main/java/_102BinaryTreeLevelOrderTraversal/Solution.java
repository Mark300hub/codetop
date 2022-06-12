package _102BinaryTreeLevelOrderTraversal;

import util.listNode.ListNode;
import util.treenode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author : i.Boss
 * @program : codetop
 * @description :
 * @create : 2022-06-06 21:34
 **/
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root != null) {
            deque.addLast(root);
        }
        List<List<Integer>> res = new ArrayList<>();
        while (!deque.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = deque.size(); i > 0; i--) {
                TreeNode temp = deque.pollFirst();
                list.add(temp.val);
                if (temp.left != null) {
                    deque.addLast(temp.left);
                }
                if (temp.right != null) {
                    deque.addLast(temp.right);
                }
            }

            res.add(list);
        }
        return res;
    }
}