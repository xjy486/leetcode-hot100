class Solution {
    private int max_so_far;

    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        max_so_far = root.val;
        dfs(root);
        return max_so_far;
    }

    public int dfs(TreeNode root) {
        if (root == null)
            return 0;

        int leftPathSum = dfs(root.left);
        int rightPathSum = dfs(root.right);
        if (leftPathSum < 0)
            leftPathSum = 0;
        if (rightPathSum < 0)
            rightPathSum = 0;
        max_so_far = Math.max(root.val + leftPathSum + rightPathSum, max_so_far);
        return root.val + Math.max(leftPathSum, rightPathSum);
    }
}