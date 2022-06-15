package _145BinaryTreePostorderTraversal;

import util.treenode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Description TODO
 * @ClassName Solution2
 * @Author haiyong.huang_sx
 * @Date 2022/6/15 17:42
 * @Version 1.0
 */
public class Solution2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode cur = root;
        TreeNode pre = null;
        //主要思想：
        //由于在某颗子树访问完成以后，接着就要回溯到其父节点去
        //因此可以用prev来记录访问历史，在回溯到父节点时，可以由此来判断，上一个访问的节点是否为右子树
        while (cur != null || !deque.isEmpty()) {
            while (cur != null) {
                deque.add(cur);
                cur = cur.left;
            }
            cur = deque.peekLast();//栈顶元素
            //现在需要确定的是是否有右子树，或者右子树是否访问过
            //如果没有右子树，或者右子树访问完了，也就是上一个访问的节点是右子节点时
            //说明可以访问当前节点
            if (cur.right == null || cur.right == pre) {
                res.add(cur.val);
                //更新历史访问记录，这样回溯的时候父节点可以由此判断右子树是否访问完成
                pre = cur;
                cur = null;
            } else {
                //如果右子树没有被访问，那么将当前节点压栈，访问右子树
                deque.addLast(cur);
                cur = cur.right;
            }
        }
        return res;
    }
}