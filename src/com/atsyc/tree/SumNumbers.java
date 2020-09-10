package com.atsyc.tree;

/**
 * 求二叉树的值
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/submissions/
 */
public class SumNumbers {

    public static int sum = 0;

    public int sumNumbers(TreeNode treeNode) {
        return dfs(0, treeNode);
    }

    public int dfs(int val, TreeNode node) {
        if (node == null) {
            return 0;
        }
        int res = val * 10 + node.val;
        if (node.left == null && node.right == null) {
            return res;
        }
        return dfs(res, node.left) + dfs(res, node.right);
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
