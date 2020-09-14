package com.atsyc.tree;

/**
 * https://leetcode-cn.com/problems/path-sum/submissions/
 */
public class HasPathSum {

    private int target = 0;

    private boolean res = false;

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        target = sum;
        dfs(root,0);
        return res;
    }

    void dfs(TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (sum + node.val == target) {
                res = true;
                return;
            }
        }
        if (node.left != null) {
            dfs(node.left, sum + node.val);
        }
        if(node.right != null){
            dfs(node.right, sum + node.val);
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
