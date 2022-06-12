package _103BinaryTreeZigzagLevelOrderTraversal;

import util.treenode.TreeNode;

import java.util.*;

/**
 * @author : i.Boss
 * @program : codetop
 * @description :
 * @create : 2022-06-12 12:07
 **/
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            deque.addLast(root);
        }
        boolean flag = false;
        while (!deque.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = deque.size(); i > 0; i--) {
                TreeNode temp = deque.pollFirst();
                list.add(temp.val);
                if (temp.left != null) {deque.addLast(temp.left);}
                if (temp.right != null) {deque.addLast(temp.right);}
            }
            if (flag) {
                Collections.reverse(list);
            }
            flag = !flag;
            res.add(list);
        }
        return res;
    }
}