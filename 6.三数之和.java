class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet<>();
        Arrays.sort(nums);

        for (int firstIndex = 0; firstIndex < nums.length; firstIndex++) {
            int target = -nums[firstIndex]; // 三数之和为0，所以后两个数的和应该等于第一个数的相反数
            int left = firstIndex + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    // 找到符合条件的三元组
                    List<Integer> triplet = Arrays.asList(nums[firstIndex], nums[left], nums[right]);
                    resultSet.add(triplet);
                    left++;
                    right--;
                }
            }
        }

        return new ArrayList<>(resultSet);
    }
}