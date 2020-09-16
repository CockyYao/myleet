package com.atsyc.tree;

/**
 * Created by doubleyao on 2020-09-16.
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    private void invert(TreeNode node) {

        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            return;
        }

        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;

        invert(node.left);
        invert(node.right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }


}
