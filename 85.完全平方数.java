class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            // dp[i] = min(dp[i - k*k] + 1) k*k <= i
            for (int k = 1; k * k <= i; k++) {
                if (k == 1) {
                    dp[i] = dp[i - k * k] + 1;
                } else {
                    dp[i] = Math.min(dp[i], dp[i - k * k] + 1);
                }

            }
        }
        return dp[n];
    }
}