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
    class Pair {
        TreeNode n;
        int index;

        Pair(TreeNode n, int index) {
            this.n = n;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        int ans = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            int firstIndex = -1;
            int lastIndex = -1;
            for (int i = 0; i < size; i++) {
                Pair a = q.remove();
                int index = a.index;
                if (firstIndex == -1) {
                    firstIndex = index;
                }
                if (i == size - 1) {
                    lastIndex = index;
                    ans = Math.max(ans, lastIndex - firstIndex + 1);
                }
                TreeNode node = a.n;
                if (node.left != null) {
                    q.add(new Pair(node.left, 2 * index + 1));
                }
                if (node.right != null) {
                    q.add(new Pair(node.right, 2 * index + 2));
                }
            }
        }
        return ans;
    }
}