/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 1. 递归的终止条件，如果当前节点是null，或者是节点p，或者节点q
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode leftResult = lowestCommonAncestor(root.left, p, q);
        TreeNode rightResult = lowestCommonAncestor(root.right, p, q);
        // 2.如果leftResult和rightResult都不为null，说明当前节点root就是公共祖先
        if (leftResult != null && rightResult != null) {
            return root;
        }
        // 3.如果leftResult和rightResult有一个为null，说明p和q都在同一颗子树下，返回leftResult或rightResult中非空的那个
        if (leftResult != null) {
            return leftResult;
        } else {
            return rightResult;
        }
        // 4.如果leftResult和rightResult都为空，那吉吉了，这题没答案
    }
}