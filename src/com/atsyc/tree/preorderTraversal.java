package com.atsyc.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by doubleyao on 2020-09-12.
 */
public class preorderTraversal {

    private List<Integer> list = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        dfs(root);
        return list;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        if(node.left != null){
            dfs(node.left);
        }
        if(node.right != null){
            dfs(node.right);
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
