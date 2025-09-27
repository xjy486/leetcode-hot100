class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] best = new int[n];
        best[0] = nums[0];
        if (n >= 2)
            best[1] = Math.max(nums[1], best[0]);
        for (int i = 2; i < nums.length; i++) {
            best[i] = Math.max(nums[i] + best[i - 2], best[i - 1]);
        }
        return best[n - 1];
    }
}