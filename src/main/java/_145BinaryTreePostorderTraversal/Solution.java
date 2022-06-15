package _145BinaryTreePostorderTraversal;

import util.treenode.TreeNode;

import java.util.*;

/**
 * @Description TODO
 * @ClassName Solution
 * @Author haiyong.huang_sx
 * @Date 2022/6/15 17:31
 * @Version 1.0
 */
// 后续迭代遍历，可以利用前序遍历的特点，后续只需要翻转结果即可
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root != null) {
            deque.addLast(root);
        }
        while (!deque.isEmpty()) {
            TreeNode temp = deque.pollLast();//栈顶元素
            res.add(temp.val);
            if (temp.left != null) {
                deque.addLast(temp.left);
            }
            if (temp.right != null) {
                deque.addLast(temp.right);
            }

        }
        Collections.reverse(res);
        return res;
    }
}