package _94BinaryTreeInorderTraversal;

import util.treenode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Description TODO
 * @ClassName Solution
 * @Author haiyong.huang_sx
 * @Date 2022/6/15 17:15
 * @Version 1.0
 */
// 二叉树的中序迭代遍历
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode cur = root;
        while (!deque.isEmpty() || cur != null) {
            while (cur != null) {// 左节点一直入栈
                deque.addLast(cur);
                cur = cur.left;
            }
            TreeNode temp = deque.pollLast();//栈顶元素
            res.add(temp.val);
            if (temp.right != null) {// 访问右子树
                cur = temp.right;
            }

        }
        return res;
    }
}