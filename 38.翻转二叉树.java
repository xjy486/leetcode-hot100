/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {

        if (root == null) return null;

        TreeNode left = invertTree(root.left);   // 递归翻转左子树
        TreeNode right = invertTree(root.right); // 递归翻转右子树
        
        root.left = right;                       // 交换
        root.right = left;
        return root;
    }
}