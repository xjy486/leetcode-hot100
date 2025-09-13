class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        boolean[] used = new boolean[nums.length];
        backTrack(new ArrayList<Integer>(), nums, used);
        return result;
    }

    void backTrack(List<Integer> current_permutation, int[] nums, boolean[] used) {
        if (current_permutation.size() == nums.length) {
            result.add(new ArrayList<>(current_permutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == true)
                continue;
            // add
            current_permutation.add(nums[i]);
            used[i] = true;
            // explore
            backTrack(current_permutation, nums, used);
            // backtrack
            current_permutation.remove(current_permutation.size() - 1);
            used[i] = false;
        }

    }
}