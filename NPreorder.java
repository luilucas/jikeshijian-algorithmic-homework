package lucas.algorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * N 叉树的层序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 */
public class NPreorder {
    public List<Integer> preorder(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        scan(root, result);

        return result;
    }

    public void scan(Node root, LinkedList<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        for (Node child : root.children) {
            scan(child, res);
        }
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
