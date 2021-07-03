package leetcode.binarytree;

import java.util.ArrayList;

/**
 * 后序遍历的递归算法
 */
public class PostOrder_Recursion {
    public ArrayList<Integer> postOrder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        list.addAll(postOrder(root.left));
        list.addAll(postOrder(root.right));
        list.add(root.val);
        return list;
    }
}
