package lagou.alg.dp;

import leetcode.binarytree.TreeNode;

/**
 * 二叉树抢劫动态规划问题
 */
public class Binary_Steal {

    // 返回值是一个pair
    // ans[0]表示抢当前根结点
    // ans[1]表示不能抢当前结点
    private long[] postOrder(TreeNode root) {
        if (root == null) {
            return new long[]{0, 0};
        }

        long[] l = postOrder(root.left);
        long[] r = postOrder(root.right);
        // 如果要抢当前结点
        long get = root.val;
        // 那么两个子结点必然不能抢
        get += l[1] + r[1];
        // 如果不抢当前结点
        long skip = 0;
        // 那么两个子结点可以抢，也可以不抢
        skip += Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new long[]{get, skip};
    }

    public int rob(TreeNode root) {
        long[] ans = postOrder(root);
        return (int) Math.max(ans[0], ans[1]);
    }
}
