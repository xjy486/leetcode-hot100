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
    // private TreeNode saveRight;
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        TreeNode saveRight = root.right;
        root.right = root.left;
        root.left = null;

        flatten(root.right);
        flatten(saveRight);
        TreeNode temp = root;
        while (temp.right != null) {
            temp = temp.right;
        }
        temp.right = saveRight;
    }
}