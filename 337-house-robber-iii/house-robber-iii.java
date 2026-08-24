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
    public int[] f(TreeNode root) {
        if (root == null)
            return new int[] { 0, 0 };
        int[] left = f(root.left);
        int[] right = f(root.right);
        int take = left[1] + right[1] + root.val;
        int notTake = Math.max(left[0], left[1]) +
                Math.max(right[0], right[1]);
        return new int[] { take, notTake };

    }

    public int rob(TreeNode root) {
        int[] result = f(root);
        return Math.max(result[0], result[1]);

    }
}