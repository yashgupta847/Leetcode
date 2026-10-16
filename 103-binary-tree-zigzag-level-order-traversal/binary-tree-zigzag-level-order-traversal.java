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
    Queue<TreeNode> q = new LinkedList<>();
    List<List<Integer>> ans;

    public void f(TreeNode root) {
        if (root == null)
            return;
        q.add(root);
        boolean leftToRight = true;
        while (!q.isEmpty()) {
            int size = q.size();

            List<Integer> demo = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode a = q.remove();
                demo.add(a.val);
                if (a.left != null) {
                    q.add(a.left);
                }
                if (a.right != null) {
                    q.add(a.right);
                }

            }
            if (!leftToRight) {
                Collections.reverse(demo);
            }
            leftToRight = !leftToRight;
            ans.add(new ArrayList<>(demo));
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ans = new ArrayList<>();
        f(root);
        return ans;
    }
}