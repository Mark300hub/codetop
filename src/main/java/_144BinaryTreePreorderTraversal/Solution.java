package _144BinaryTreePreorderTraversal;

import util.treenode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Description TODO
 * @ClassName Solution
 * @Author haiyong.huang_sx
 * @Date 2022/6/15 16:51
 * @Version 1.0
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=  new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root != null) {
            deque.addLast(root);
        }
        while (!deque.isEmpty()) {
            TreeNode temp = deque.pollLast();
            res.add(temp.val);
            if (temp.right != null) {
                deque.addLast(temp.right);
            }
            if (temp.left != null) {
                deque.addLast(temp.left);
            }

        }
        return res;
    }
}