package leetcode.subset;

/**
 * 状态压缩
 * not ac
 *
 */
public class CompactPartition {
    public static void main(String[] args) {
        int[] nums1 = {1, 5, 11, 5};
        System.out.println(canPartition(nums1));
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum = sum + num;
        int n = nums.length;
        if (sum % 2 != 0)
            return false;

        boolean[] dp = new boolean[sum + 1];
        //base case
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = sum; j >= 0; j--) {
                if (j - nums[i] >= 0) {
                    dp[j] = dp[j] | dp[j - nums[i]];
                }
            }
        }
        return dp[sum];
    }

}
