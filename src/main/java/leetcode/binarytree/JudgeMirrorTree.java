package leetcode.binarytree;

/**
 * 判断两棵树是否互为镜像
 */
public class JudgeMirrorTree {
    public boolean isMirrorTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        return isMirrorTree(t1.left, t2.right) && isMirrorTree(t1.right, t2.left);

    }


}

