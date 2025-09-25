class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1)
            return 0;
        int jumps = 0;
        int farthest_reach = 0;
        int current_jump_end = 0;

        for (int i = 0; i < nums.length; i++) {
            farthest_reach = Math.max(farthest_reach, nums[i] + i);
            if (i == current_jump_end) {
                current_jump_end = farthest_reach;
                jumps++;
            }
            if (current_jump_end >= nums.length - 1) {
                break;
            }

        }
        return jumps;
    }
}