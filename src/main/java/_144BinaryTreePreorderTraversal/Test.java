package _144BinaryTreePreorderTraversal;

import util.buildbinarytree.BuildBinaryTree;
import util.treenode.TreeNode;

import java.util.Arrays;
import java.util.List;

/**
 * @Description TODO
 * @ClassName Test
 * @Author haiyong.huang_sx
 * @Date 2022/6/15 17:05
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        BuildBinaryTree buildBinaryTree = new BuildBinaryTree();
        String s = "1,2,3,4,5,6,7,#,#,#,#,#,#,#,#,";
        TreeNode root = buildBinaryTree.deserialize(s);
        Solution solution = new Solution();
        List<Integer> integers = solution.preorderTraversal(root);
        System.out.println(integers.toString());
    }
}