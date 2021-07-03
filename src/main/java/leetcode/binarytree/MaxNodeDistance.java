package leetcode.binarytree;

/**
 * 两个节点间的最长距离
 * 二叉树中两个节点的最长距离可能有三种情况：
 * 1.左子树的最大深度+右子树的最大深度为二叉树的最长距离
 * 2.左子树中的最长距离即为二叉树的最长距离
 * 3.右子树种的最长距离即为二叉树的最长距离
 * 因此，递归求解即可
 */
public class MaxNodeDistance {

    private static class Result {
        int maxDistance;
        int maxDepth;

        public Result() {
        }

        public Result(int maxDistance, int maxDepth) {
            this.maxDistance = maxDistance;
            this.maxDepth = maxDepth;
        }
    }

    int getMaxDistance(TreeNode root) {
        return getMaxDistanceResult(root).maxDistance;
    }

    Result getMaxDistanceResult(TreeNode root) {
        if (root == null) {
            Result empty = new Result(0, -1);
            return empty;
        }
        Result lmd = getMaxDistanceResult(root.left);
        Result rmd = getMaxDistanceResult(root.right);
        Result result = new Result();
        result.maxDepth = Math.max(lmd.maxDepth, rmd.maxDepth) + 1;
        result.maxDistance = Math.max(lmd.maxDepth + rmd.maxDepth, Math.max(lmd.maxDistance, rmd.maxDistance));
        return result;
    }
}
