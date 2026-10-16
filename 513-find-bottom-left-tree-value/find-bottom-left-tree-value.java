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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int ans = root.val;
        boolean cantakeleft = false;
        while (!q.isEmpty()) {
            int size = q.size();
            cantakeleft = false;
            for (int i = 0; i < size; i++) {
                TreeNode a = q.remove();
                if (!cantakeleft) {
                    ans = a.val;
                    cantakeleft = true;
                }
                if (a.left != null) {
                    q.add(a.left);
                }
                if (a.right != null) {
                    q.add(a.right);
                }
            }

        }
        return ans;
    }
}