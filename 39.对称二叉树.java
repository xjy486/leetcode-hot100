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
    public boolean isSymmetric(TreeNode root) {
        TreeNode node1 = root.left;
        TreeNode node2 = root.right;
       return isSame(node1,node2);
    }
    public boolean isSame(TreeNode n1, TreeNode n2){
        if(n1 == null && n2 == null) return true;
        if(n1 == null || n2 == null) return false;
        if(n1.val != n2.val) {
            return false;
        }
        boolean left = isSame(n1.left, n2.right);
        boolean right = isSame(n1.right, n2.left);
        return left && right;
    }
}