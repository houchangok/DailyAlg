package leetcode.binarytree;

/**
 * 根据前序遍历和中序遍历构建二叉树
 */
public class BuildTreeBySequence {

    TreeNode buildTreeNode(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) {
            return null;
        }
        return myBuildTree(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
    }

    TreeNode myBuildTree(int[] inorder, int instart, int inend, int[] preorder, int prestart, int preend) {
        if (instart > inend) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[prestart]);
        int position = findPosition(inorder, instart, inend, preorder[instart]);
        //注意计算边界值
        root.left = myBuildTree(inorder, instart, position - 1, preorder, prestart + 1, prestart + position - instart);
        root.right = myBuildTree(inorder, position + 1, inend, preorder, position - inend + preend + 1, preend);
        return root;
    }

    int findPosition(int[] arr, int start, int end, int key) {
        int i;
        for (i = start; i <= end; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }


}
