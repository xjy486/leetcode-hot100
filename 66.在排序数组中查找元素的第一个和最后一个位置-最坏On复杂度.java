class Solution {
    int[] result = new int[2];

    public int[] searchRange(int[] nums, int target) {
        result[0] = nums.length;
        result[1] = -1;
        search(nums, target, 0, nums.length - 1);
        if (result[0] == nums.length)
            result[0] = -1;
        return result;

    }

    public int search(int[] nums, int target, int left, int right) {

        while (left <= right) {
            int middle = (left + right) / 2;
            if (target > nums[middle]) {
                left = middle + 1;
            } else if (target < nums[middle]) {
                right = middle - 1;
            } else {
                int leftBound = search(nums, target, left, middle - 1);
                int rightBound = search(nums, target, middle + 1, right);
                if (leftBound != -1) {
                    result[0] = Math.min(leftBound, result[0]);
                } else {
                    result[0] = Math.min(middle, result[0]);
                }
                if (rightBound != -1) {
                    result[1] = Math.max(rightBound, result[1]);
                } else {
                    result[1] = Math.max(middle, result[1]);
                }
                return middle;

            }
        }
        return -1;
    }
}