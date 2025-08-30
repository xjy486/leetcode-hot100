class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int left_products = 1;
        int right_products = 1;
        int[] result = new int[n];
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            left_products *= nums[i - 1];
            result[i] = left_products;
        }
        for (int i = n - 2; i >= 0; i--) {
            right_products *= nums[i + 1];
            result[i] *= right_products;
        }
        return result;
    }
}