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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       return buildTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
    public TreeNode buildTree(int[] preorder, int[] inorder, int pre_s, int pre_e, int in_s, int in_e) {
        if(pre_s > pre_e) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[pre_s]);
        // 将中序遍历数组划分成两部分
        int i;
        for(i = in_s; i <= in_e; i++) {
            if(inorder[i] == node.val) {
                break;
            }
        }
        int leftTreeLen = i - in_s;
        node.left = buildTree(preorder, inorder, pre_s+1, pre_s+leftTreeLen, in_s, i-1);
        node.right = buildTree(preorder, inorder, pre_s+leftTreeLen+1, pre_e, i+1, in_e);
        return node;
    }
}