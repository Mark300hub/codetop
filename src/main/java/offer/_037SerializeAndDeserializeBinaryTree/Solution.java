package offer._037SerializeAndDeserializeBinaryTree;

import util.treenode.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : i.Boss
 * @program : codetop
 * @description :
 * @create : 2022-06-07 08:12
 **/
public class Solution {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        if (root != null) {
            deque.addLast(root);
        }
        StringBuilder res = new StringBuilder();
        while (!deque.isEmpty()) {
            for (int i = deque.size(); i > 0; i--) {
                TreeNode temp = deque.pollFirst();
                if (temp != null) {
                    deque.addLast(temp.left);
                    deque.addLast(temp.right);
                    res.append(temp.val).append(",");
                } else {
                    res.append("#").append(",");
                }
            }
        }
        return res.toString();
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
     String[] nodes = data.split(",");
     TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
     Deque<TreeNode> deque = new ArrayDeque<>();
     deque.addLast(root);
     for (int i = 1; i < nodes.length;) {
         TreeNode node = deque.pollFirst();
         String left = nodes[i++];
         if (!left.equals("#")) {
             node.left = new TreeNode(Integer.parseInt(left));
             deque.addLast(node.left);
         }
         String right = nodes[i++];
         if (!right.equals("#")) {
             node.right = new TreeNode(Integer.parseInt(right));
             deque.addLast(node.right);
         }
     }
     return root;
    }
}