package com.atsyc.tree;

/**
 * Created by doubleyao on 2020-11-17.
 */
public class IsBlanced {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);

        return left == right || left == right + 1 || left == right - 1;
    }

    private int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
    }




}
