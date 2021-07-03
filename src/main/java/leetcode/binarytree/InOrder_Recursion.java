package leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中序遍历的递归算法
 */
public class InOrder_Recursion {

    public List<Integer> inOrder(TreeNode treeNode) {
        List<Integer> result = new ArrayList<Integer>();
        if (treeNode == null) {
            return result;
        }
        result.addAll(inOrder(treeNode.left));
        result.add(treeNode.val);
        result.addAll(inOrder(treeNode.right));
        return result;
    }
}
