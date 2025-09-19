class Solution {
    public int search(int[] nums, int target) {
        int reversePos = findRversePos(nums);
        int lres = findTarget(nums, 0, reversePos, target);
        int rres = findTarget(nums, reversePos + 1, nums.length - 1, target);
        // return reversePos;
        if (lres != -1)
            return lres;
        if (rres != -1)
            return rres;
        return -1;
    }

    public int findRversePos(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            // 使用向上取整来防止当 left 和 right 相邻时出现无限循环
            int middle = left + (right - left + 1) / 2;

            if (nums[middle] >= nums[left]) {
                left = middle;
            } else {
                right = middle - 1;
            }
        }
        return left;
    }

    public int findTarget(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] < target)
                left = middle + 1;
            else if (nums[middle] > target)
                right = middle - 1;
            else
                return middle;
        }
        return -1;
    }
}