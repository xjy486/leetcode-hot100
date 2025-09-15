class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(candidates, target, new ArrayList<>(), 0, 0);
        return result;
    }

    public void backTrack(int[] candidates, int target, List<Integer> currResult, int currSum, int index) {
        if (target == currSum) {
            result.add(new ArrayList(currResult));
            return;
        } else if (target < currSum)
            return;
        for (int i = index; i < candidates.length; i++) {
            currResult.add(candidates[i]);
            currSum += candidates[i];
            backTrack(candidates, target, currResult, currSum, i);
            currResult.remove(currResult.size() - 1);
            currSum -= candidates[i];
        }
    }
}