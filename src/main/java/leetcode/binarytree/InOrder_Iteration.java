package leetcode.binarytree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 二叉树中序遍历迭代算法
 */
public class InOrder_Iteration {

    public ArrayList<Integer> inOrder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        while (current != null || !stack.empty()) {
            //找到最左边的left节点
            while (current != null) {
                stack.add(current);
                current = current.left;
            }
            current = stack.peek();
            stack.pop();
            list.add(current.val);
            current = current.right;
        }
        return list;
    }

}
