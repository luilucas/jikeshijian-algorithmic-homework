package lucas.algorithm.week04;

import lucas.algorithm.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/#/description
 */
public class LevelOrder2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentQueueSize = queue.size();
            for (int i = 0; i < currentQueueSize; i++) {
                TreeNode parent = queue.pollFirst();
                level.add(parent.val);
                if (parent.left != null) {
                    queue.addLast(parent.left);
                }
                if (parent.right != null) {
                    queue.addLast(parent.right);
                }
            }

            result.add(level);
        }
        return result;
    }
}
