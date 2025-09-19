public class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;

        // 如果数组没旋转，直接返回首元素
        if (nums[lo] < nums[hi])
            return nums[lo];

        // 二分找“第一个小于 nums[0]”的位置
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2; // 向下取中
            if (nums[mid] < nums[0]) {
                hi = mid; // 答案在左半部分（含 mid）
            } else {
                lo = mid + 1; // 答案在右半部分（不含 mid）
            }
        }
        return nums[lo]; // lo 就是最小值下标
    }
}