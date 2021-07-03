package leetcode.binarytree;

import java.util.ArrayList;

/**
 * 前序遍历的递归算法
 */
public class PerOrder_Recursion {

    ArrayList<Integer> preOrderReverse(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        preOrder2(root, result);
        return result;
    }

    void preOrder2(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preOrder2(root.left, result);
        preOrder2(root.right, result);
    }
}
