package offer._037SerializeAndDeserializeBinaryTree;

import _297SerializeAndDeserializeBinaryTree.Solution;

import util.treenode.TreeNode;

/**
 * @author : i.Boss
 * @program : codetop
 * @description :
 * @create : 2022-06-07 21:15
 **/
public class Test {
    public static void main(String[] args) {
        Solution solution297 = new Solution();
        String data = "1,2,4,#,#,5,#,#,3,6,#,#,7,#,#,";
        TreeNode root = solution297.deserialize(data);
        offer._037SerializeAndDeserializeBinaryTree.Solution solution = new offer._037SerializeAndDeserializeBinaryTree.Solution();
        System.out.println(root);
        String serialize = solution.serialize(root);
        System.out.println(serialize);
        System.out.println(solution.deserialize(serialize));
    }
}