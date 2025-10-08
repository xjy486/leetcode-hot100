class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }

        // 如果总和为奇数，无法平分；或最大值超过一半，也不可能
        if (sum % 2 != 0 || max > sum / 2) {
            return false;
        }

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {

            for (int i = target; i >= 0; i--) {
                if (dp[i] == true && i + num <= target)
                    dp[i + num] = true;

            }
            dp[num] = true;

        }

        return dp[target];
    }
}