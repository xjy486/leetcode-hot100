class Solution {
    public int maxSubArray(int[] nums) {
        int max_so_far = nums[0];
        int current_sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (current_sum < 0) {
                current_sum = nums[i];
            } else {
                current_sum += nums[i];
            }
            max_so_far = max_so_far > current_sum ? max_so_far : current_sum;
        }
        return max_so_far;
    }
}