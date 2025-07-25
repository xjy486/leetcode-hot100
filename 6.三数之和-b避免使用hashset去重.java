class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3)
            return result;

        Arrays.sort(nums);

        for (int firstIndex = 0; firstIndex < nums.length - 2; firstIndex++) {
            // 提前剪枝：如果最小的数都大于0，后面不可能有解
            if (nums[firstIndex] > 0)
                break;

            // 跳过重复的第一个元素，这样可以避免使用HashSet
            if (firstIndex > 0 && nums[firstIndex] == nums[firstIndex - 1]) {
                continue;
            }

            int target = -nums[firstIndex];
            int left = firstIndex + 1;
            int right = nums.length - 1;

            // 提前剪枝：检查边界情况
            if (nums[left] + nums[left + 1] > target)
                continue;
            if (nums[right] + nums[right - 1] < target)
                continue;

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[firstIndex], nums[left], nums[right]));

                    // 跳过重复元素
                    while (left < right && nums[left] == nums[left + 1])
                        left++;
                    while (left < right && nums[right] == nums[right - 1])
                        right--;

                    left++;
                    right--;
                }
            }
        }

        return result;
    }
}