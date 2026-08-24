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

    public void f(TreeNode root, int max) {
        if (root == null)
            return;
        if (root.val >= max) {
            max = root.val;
            ans++;
        }
        f(root.left, max);
        f(root.right, max);
    }

    public int goodNodes(TreeNode root) {
        f(root, Integer.MIN_VALUE);
        return ans;
    }
}