class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        backTrack(nums, 0, new ArrayList<Integer>());
        // result.add(new ArrayList<>());
        return result;
    }

    public void backTrack(int[] nums, int index, List<Integer> currentSubset) {
        result.add(new ArrayList<>(currentSubset));
        for (int i = index; i < nums.length; i++) {
            currentSubset.add(nums[i]);
            backTrack(nums, i + 1, currentSubset);
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}