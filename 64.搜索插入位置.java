class Solution {
    public int searchInsert(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    public int search(int[] nums, int target, int left, int right) {
        if (right < left)
            return left;
        int middle = (left + right) / 2;
        if (nums[middle] < target)
            return search(nums, target, middle + 1, right);
        else if (nums[middle] > target)
            return search(nums, target, left, middle - 1);
        else
            return middle;
    }
}