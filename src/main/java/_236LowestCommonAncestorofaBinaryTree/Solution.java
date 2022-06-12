package _236LowestCommonAncestorofaBinaryTree;

import util.treenode.TreeNode;

/**
 * @author : i.Boss
 * @program : codetop
 * @description :
 * @create : 2022-06-08 19:44
 **/
// 二叉树的最近公共祖先
public class Solution {
    /**
     *  由于不是BST，所以无法判断p，q位于root的哪一侧
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 1、左右侧都为未找到p、q
        if (left == null && right == null) {
            return null;
        }
        // 2、左侧没有找到p、q
        if (left == null) {
            return right;
        }
        // 3、右侧没有找到p、q
        if (right == null) {
            return left;
        }
        // 4、左右两侧分别找到了p、q
        return root;
    }
}