class Solution {
    int[] result = new int[2];

    public int[] searchRange(int[] nums, int target) {
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);

        return result;

    }

    public int findFirst(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int firstIndex = -1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (target > nums[middle]) {
                left = middle + 1;
            } else if (target < nums[middle]) {
                right = middle - 1;
            } else {
                firstIndex = middle;
                right = middle - 1;
            }
        }
        return firstIndex;
    }

    public int findLast(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int lastIndex = -1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                lastIndex = middle;
                left = middle + 1;
            }
        }
        return lastIndex;
    }
}