package algorithm.src.com.atsyc.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by doubleyao on 2020-09-08.
 */
public class WidthOfBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int width = 1;
        // 记录下标的队列
        LinkedList<Integer> indexList = new LinkedList<>();
        indexList.add(1);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                Integer currentIdx = indexList.removeFirst();
                if (node.left != null) {
                    queue.add(node.left);
                    indexList.add(2 * currentIdx);
                }

                if (node.right != null) {
                    queue.add(node.right);
                    indexList.add(2 * currentIdx + 1);
                }
                size--;
            }
            if (indexList.size() > 1) {
                width = Math.max(width, indexList.getLast() - indexList.getFirst() + 1);
            }
        }
        return width;
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
