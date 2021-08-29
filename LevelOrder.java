package lucas.algorithm.week04;

import lucas.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/#/description
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }

        scan(root, 1, result);
        return result;
    }

    private void scan(TreeNode root, int level, List<List<Integer>> res) {
        if (res.size() < level) {
            res.add(new ArrayList<>());
        }

        res.get(level - 1).add(root.val);
        if (root.left != null) {
            scan(root.left, level + 1, res);
        }
        if (root.right != null) {
            scan(root.right, level + 1, res);
        }
    }
}
