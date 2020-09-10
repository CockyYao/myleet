package com.atsyc.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by doubleyao on 2020-09-09.
 */
public class InorderTraversal {

    private List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        visit(root);
        return list;
    }

    private void visit(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            visit(root.left);
        }
        list.add(root.val);
        if (root.right != null) {
            visit(root.right);
        }
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
