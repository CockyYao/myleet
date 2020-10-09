package com.atsyc.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by doubleyao on 2020-09-29.
 */
public class PostOrderTravel {

    private List<Integer> list = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        dfs(root);
        return list;
    }

    private void dfs(TreeNode root) {
        if(root == null){
            return;
        }
        dfs(root.left);
        dfs(root.right);
        list.add(root.val);
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
