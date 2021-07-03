package leetcode.binarytree;

/**
 * 翻转二叉树（镜像树）
 */
public class TransferMirrorTree {

    public TreeNode mirrorTree(TreeNode t) {
        if (t == null) {
            return null;
        }
        //左子树翻转
        TreeNode left = mirrorTree(t.left);
        //右子树翻转
        TreeNode right = mirrorTree(t.right);
        //整体翻转
        t.left = right;
        t.right = left;
        return t;
    }

}
