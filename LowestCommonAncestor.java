package lucas.algorithm.week03;

/**
 * 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LowestCommonAncestor {
    private TreeNode res;
    public LowestCommonAncestor(){
        this.res = null;
    }

    public InvertTree.TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        isFound(root, p, q);
        return res;
    }

    private boolean isFound(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean l = isFound(root.left, p, q);
        boolean r = isFound(root.right, p, q);
        if ((l && r) || ((root.val == p.val || root.val == q.val) && (l || r))) {
            res = root;
        }

        return ((root.val == p.val || root.val == q.val)) || (l || r);
    }
}
