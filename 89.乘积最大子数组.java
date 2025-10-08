class Solution {
    public int maxProduct(int[] nums) {
        int overallMaxProd = nums[0];
        int maxProd = nums[0];
        int minProd = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tempMaxProd = nums[i] * maxProd;
            int tempMinProd = nums[i] * minProd;
            maxProd = Math.max(nums[i], Math.max(tempMaxProd, tempMinProd));
            minProd = Math.min(nums[i], Math.min(tempMaxProd, tempMinProd));
            overallMaxProd = Math.max(overallMaxProd, maxProd);
        }
        return overallMaxProd;
    }
}