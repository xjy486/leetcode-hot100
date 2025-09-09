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
    private Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd)
            return null;

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int rootIndexInInorder = inorderMap.get(rootVal);
        int leftSubtreeSize = rootIndexInInorder - inStart;

        root.left = buildTree(preorder,
                preStart + 1,
                preStart + leftSubtreeSize,
                inStart,
                rootIndexInInorder - 1);

        root.right = buildTree(preorder,
                preStart + leftSubtreeSize + 1,
                preEnd,
                rootIndexInInorder + 1,
                inEnd);

        return root;
    }
}