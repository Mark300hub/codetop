package _297SerializeAndDeserializeBinaryTree;

import util.treenode.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author : i.Boss
 * @program : codetop
 * @description :
 * @create : 2022-06-07 08:01
 **/
// 序列化与反序列化二叉树：使用前序遍历
public class Solution {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        serialize(root, builder);
        return builder.toString();
    }

    private void serialize(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append("#").append(",");
            return;
        }
        builder.append(root.val).append(",");
        serialize(root.left, builder);
        serialize(root.right, builder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("") || data.startsWith("#")) {
            return null;
        }
        String[] strings = data.split(",");
        ArrayDeque<String> deque = new ArrayDeque<>(Arrays.asList(strings));
        return deserialize(deque);
    }

    private TreeNode deserialize(ArrayDeque<String> deque) {
        if (deque.getFirst().equals("#")) {
            deque.pollFirst();
            return null;
        }
        String s = deque.pollFirst();
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = deserialize(deque);
        root.right = deserialize(deque);
        return root;
    }
}