package leetcode.binarytree;

import java.util.Stack;

/**
 * 输入一个二叉树和一个整数，打印出二叉树中节点值的和等于输入整数所有的路径
 */
public class FindAllSumPath {
    void findPath(TreeNode r, int i) {
        if (r == null) {
            return;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int currentSum = 0;
        findPath(r, i, stack, currentSum);
    }

    void findPath(TreeNode r, int i, Stack<Integer> stack, int currentSum) {

        currentSum += r.val;
        stack.push(r.val);
        if (r.left == null && r.right == null) {
            if (currentSum == i) {
                for (int path : stack) {
                    System.out.println(path);
                }
            }
        }
        if (r.left != null) {
            findPath(r.left, i, stack, currentSum);
        }
        if (r.right != null) {
            findPath(r.right, i, stack, currentSum);
        }
        stack.pop();
    }
}
