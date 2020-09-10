package algorithm.src.com.atsyc.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by doubleyao on 2020-09-09.
 */
public class IsValidBST {

    private List<Integer> leftList = new ArrayList<>();
    private List<Integer> rightList = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        int val = root.val;
        return greatThan(val, root.left) && lessThan(val, root.right);
    }

    boolean greatThan(int val, TreeNode left) {
        visitLeft(left);
        return leftList.stream().allMatch(t -> val > t);
    }

    boolean lessThan(int val, TreeNode right) {
        visitRight(right);
        return rightList.stream().allMatch(t -> val < t);
    }

    void visitLeft(TreeNode node) {
        if(node == null){
            return;
        }
        leftList.add(node.val);
        if (node.right != null) {
            visitLeft(node.right);
        }
        if (node.left != null) {
            visitLeft(node.left);
        }
    }

    void visitRight(TreeNode node) {
        if(node == null){
            return;
        }
        rightList.add(node.val);
        if (node.right != null) {
            visitRight(node.right);
        }
        if (node.left != null) {
            visitRight(node.left);
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
