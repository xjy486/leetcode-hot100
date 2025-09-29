class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++)
            dp[i] = amount + 1;
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int k = 0; k < coins.length; k++) {
                if (i >= coins[k])
                    dp[i] = Math.min(dp[i], dp[i - coins[k]] + 1);
                else
                    continue;
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}