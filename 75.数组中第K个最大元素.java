class Solution {
    public int findKthLargest(int[] nums, int k) {
        return qSort(nums, 0, nums.length - 1, k);
    }

    public int qSort(int[] nums, int l, int r, int k) {
        if (l < r) {
            int pos = partition(nums, l, r);
            if (pos > nums.length - k) {
                return qSort(nums, l, pos - 1, k);
            } else if (pos < nums.length - k) {
                return qSort(nums, pos + 1, r, k);
            } else {
                return nums[pos];
            }
        }
        return nums[l];

    }

    public int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        while (l < r) {
            while (l < r && nums[l] <= pivot)
                l++;
            nums[r] = nums[l];
            while (l < r && nums[r] >= pivot)
                r--;
            nums[l] = nums[r];

        }
        nums[l] = pivot;
        return l;
    }
}