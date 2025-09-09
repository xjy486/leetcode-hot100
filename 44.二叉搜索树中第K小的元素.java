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
    private int result; // 用来存放最终结果
    private int count; // 用来计数

    public int kthSmallest(TreeNode root, int k) {
        // 在这里调用一个辅助的递归函数
        inorder(root, k);
        return result; // 最后返回结果
    }

    private void inorder(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        // 1. 递归左子树
        inorder(node.left, k);
        count++;
        if (count == k) {
            result = node.val;
        }

        // 3. 递归右子树
        inorder(node.right, k);
    }
}