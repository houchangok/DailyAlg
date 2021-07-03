package leetcode.binarytree;

/**
 * 在二叉树上插入节点
 */
public class InsertNode {
    TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == node|| root.val==node.val) {
            return node;
        }
        TreeNode tmp = new TreeNode();
        tmp = root;
        TreeNode last = null;
        while (tmp != null) {
            last = tmp;
            if (tmp.val > node.val) {
                tmp = tmp.left;
            } else {
                tmp = tmp.right;
            }
        }
        if (last != null) {
            if (last.val > node.val) {
                last.left = node;
            } else {
                last.right = node;
            }
        }
        return root;
    }
}
