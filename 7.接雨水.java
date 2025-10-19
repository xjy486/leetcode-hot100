/**
 * 根本不会写啊
 * 2025/10/19二更：
 * 双指针法
 * 时间复杂度O(n)，空间复杂度O(1)
 * 使用leftMax和rightMax记录左侧和右侧的最大高度
 * 每次移动较矮的指针，更新总水量
 * 当前位置能容纳的水量取决于左右两侧最大高度的较小者
 * 当前位置的水量 = min(leftMax, rightMax) - height[current]
 */
class Solution {
    public int trap(int[] height) {
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(height[left], leftMax);
                ans += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(height[right], rightMax);
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }
}
// class Solution {
// public int trap(int[] height) {
// if (height == null || height.length == 0) {
// return 0;
// }

// int n = height.length;
// int left = 0, right = n - 1;
// int leftMax = 0, rightMax = 0;
// int totalWater = 0;

// while (left < right) {
// if (height[left] < height[right]) {
// // 左侧较矮，雨水高度由左侧决定
// if (height[left] >= leftMax) {
// leftMax = height[left];
// } else {
// totalWater += leftMax - height[left];
// }
// left++;
// } else {
// if (height[right] >= rightMax) {
// rightMax = height[right];
// } else {
// totalWater += rightMax - height[right];
// }
// right--;
// }
// }

// return totalWater;
// }
// }