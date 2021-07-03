package leetcode;

public class throw_egg_1 {
    public static void main(String[] args) {
        System.out.println(egg_throw_count(2, 100));
    }

    public static int egg_throw_count(int k, int n) {
        int[][] memo = new int[k][n];

        return solve(k, n, memo);


    }

    private static int solve(int k, int n, int[][] dp) {
        //base case
        if (k == 1)
            return n;
        if (n == 0)
            return 0;
        if (dp[k-1][n-1] != 0) {
            return dp[k-1][n-1];
        }

        Integer res = Integer.MAX_VALUE;
        //穷尽所有的可能情况
        for (int i = 1; i <= n; i++) {
            res = Math.min(res, Math.max(solve(k, n - 1, dp), solve(k - 1, i - 1, dp))) + 1;
        }
        dp[k-1][n-1] = res;
        return res;

    }
}
