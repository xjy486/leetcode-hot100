class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        // 当前元素左侧乘积（从左往右乘）
        int[] left_products = new int[n];
        // 当前元素右侧乘积（从右往左乘）
        int[] right_products = new int[n];
        int[] result = new int[n];
        left_products[0] = 1;
        for (int i = 1; i < n; i++) {
            left_products[i] = left_products[i - 1] * nums[i - 1];
        }
        right_products[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right_products[i] = right_products[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < n; i++) {
            result[i] = left_products[i] * right_products[i];
        }
        return result;
    }
}