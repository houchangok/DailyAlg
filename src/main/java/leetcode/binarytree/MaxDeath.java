package leetcode.binarytree;

/**
 * 求二叉树的最大深度
 */
public class MaxDeath {
    int maxDeath(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = maxDeath(node.left);
        int right = maxDeath(node.right);
        return Math.max(left, right) + 1;
    }

}

