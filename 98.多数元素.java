class Solution {
    public int majorityElement(int[] nums) {
        int count = 1;
        int candiate = nums[0];
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == candiate) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                candiate = nums[i];
                count = 1;
            }
        }
        return candiate;
    }
}