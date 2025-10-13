class Solution {
    public void nextPermutation(int[] nums) {
        int i, j;
        for (i = nums.length - 2; i >= 0 && nums[i] >= nums[i + 1]; i--)
            ;
        if (i == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        for (j = nums.length - 1; j > i; j--) {
            if (nums[j] > nums[i])
                break;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        reverse(nums, i + 1, nums.length - 1);
        return;
    }

    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}