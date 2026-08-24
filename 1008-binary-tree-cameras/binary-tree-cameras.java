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
    int ans = 0;

    public int dfs(TreeNode root) {
        if (root == null)
            return 1;
        if (root.left == null && root.right == null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left == 0 || right == 0) {
            ans++;
            return 2;
        }
        if (left == 2 || right == 2)
            return 1;
        // if (left == 1 || right == 1) {
        // ans++;
        return 0;
        // }
    }

    public int minCameraCover(TreeNode root) {
        int result = dfs(root);
        if (result == 0)
            ans++;
        return ans;
    }
}