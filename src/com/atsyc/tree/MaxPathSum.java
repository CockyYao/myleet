package com.atsyc.tree;

/**
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 */
public class MaxPathSum {

    private int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        help(root);
        return res;
    }

    private int help(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int now = node.val;
        int left = help(node.left);
        int right = help(node.right);

        // 返回的节点应该是：这一个节点，或者是，这个节点加上左节点，或者是 这个节点加上右节点
        int returnVal = Math.max(Math.max(now + left, now + right),now);

        int cur = Math.max(left,0) + now + Math.max(0,right);
        res = Math.max(cur,res);

        return returnVal;
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
