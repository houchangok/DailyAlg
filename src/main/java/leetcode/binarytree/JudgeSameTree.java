package leetcode.binarytree;

/**
 * 判断两棵树是否相等
 */
public class JudgeSameTree {

    public boolean isSameTree(TreeNode t1, TreeNode t2) {
        //都为空树，相等
        if (t1 == null && t2 == null) {
            return true;
        }
        //有一个树不为空，不相等
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        boolean left = isSameTree(t1.left, t2.left);
        boolean right = isSameTree(t1.right, t2.right);
        return left && right;
    }

}
