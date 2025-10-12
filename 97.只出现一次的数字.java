class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            result = nums[i - 1] ^ nums[i];
        }
        return result;
    }
}