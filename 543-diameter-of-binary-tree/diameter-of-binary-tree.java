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
    public int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        h(root);
        return ans;
    }

    public int h(TreeNode root) {
        if (root == null)
            return 0;
        int left = h(root.left);
        int right = h(root.right);
        ans = Math.max(left + right, ans);
        return Math.max(left, right) + 1;
    }
}