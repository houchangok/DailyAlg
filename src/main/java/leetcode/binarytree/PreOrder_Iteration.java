package leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树前序遍历的迭代算法
 */
public class PreOrder_Iteration {

    public List<Integer> preOrder(TreeNode t) {
        Stack<TreeNode> queue = new Stack<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();
        if (t == null) {
            return result;
        }
        queue.add(t);
        while (!queue.empty()) {
            //右节点先入栈
            TreeNode treeNode = queue.pop();
            //存入节点值
            result.add(treeNode.val);
            if (treeNode.right != null) {
                queue.push(treeNode.right);
            }
            //左节点后入栈
            if (treeNode.left != null) {
                queue.push(treeNode.left);
            }
        }
        return result;
    }


}
