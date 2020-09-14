package com.atsyc.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 *  dfs
 * https://leetcode-cn.com/problems/path-sum-ii/submissions/
 */
public class PathSum {

    private List<List<Integer>> resultList = new ArrayList<>();

    private int target = 0;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return resultList;
        }
        target = sum;
        dfs(root, new LinkedList<>(), 0);
        return resultList;
    }

    private void dfs(TreeNode node, List<Integer> list, int sum) {

        if (node == null) {
            return;
        }
        list.add(node.val);
        if (node.left == null && node.right == null) {
            if (node.val + sum == target) {
                resultList.add(new ArrayList<>(list));
            }
        }
        if(node.left != null){
            dfs(node.left, list, sum + node.val);
        }
        if(node.right != null){
            dfs(node.right, list, sum + node.val);
        }
        list.remove(list.size()-1);
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
