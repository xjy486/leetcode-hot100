/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    private Map<Long, Integer> prefixSumMap = new HashMap<>();
    private int result = 0;

    public int pathSum(TreeNode root, int targetSum) {
        prefixSumMap.put(0L, 1);
        dfs(root, targetSum, 0L);
        return result;
    }

    public void dfs(TreeNode root, int targetSum, long currentSum) {
        if (root == null)
            return;
        currentSum += root.val;
        result += prefixSumMap.getOrDefault(currentSum - targetSum, 0);
        prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);
        dfs(root.left, targetSum, currentSum);
        dfs(root.right, targetSum, currentSum);
        prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) - 1);
    }
}