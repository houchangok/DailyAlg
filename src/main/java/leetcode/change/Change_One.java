package leetcode.change;

public class Change_One {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{1, 2, 5}));
    }

    public static int solution(int amount, int[] coins) {
        int n = coins.length;
        //dp
        int[][] dp = new int[n + 1][amount + 1];
        //base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                //第i个coin能够放入
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][amount];
    }
}
