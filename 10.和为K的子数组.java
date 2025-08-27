class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0; // 1. 记录满足条件的子数组个数
        int current = 0; // 2. 当前前缀和
        Map<Integer, Integer> prefix_map = new HashMap<>(); // 3. 存储前缀和及其出现次数
        prefix_map.put(current, 1); // 4. 初始化前缀和为0出现1次

        // 5. 遍历数组
        for (int i = 0; i < nums.length; i++) {
            current += nums[i]; // 6. 更新当前前缀和
            int target = current - k; // 7. 计算目标前缀和
            count += prefix_map.getOrDefault(target, 0); // 8. 如果目标前缀和存在，累加其出现次数
            prefix_map.put(current, prefix_map.getOrDefault(current, 0) + 1); // 9. 更新当前前缀和出现次数
        }
        return count; // 10. 返回满足条件的子数组个数
    }
}