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
    public TreeNode canMerge(List<TreeNode> trees) {
        HashMap<Integer, TreeNode> hs = new HashMap<>();
        HashSet<Integer> hash = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        for (int i = 0; i < trees.size(); i++) {
            TreeNode root = trees.get(i);
            if (hs.put(root.val, root) != null) {
                return null;
            }
            if (root.left != null) hash.add(root.left.val);
            if (root.right != null) hash.add(root.right.val);
        }

        TreeNode root = null;

        for (int key : hs.keySet()) {
            if (!hash.contains(key)) {
                if (root != null) return null;
                root = hs.get(key);
            }
        }

        if (root == null) return null;

        hs.remove(root.val);

        if (!dfs(root, Long.MIN_VALUE, Long.MAX_VALUE, hs)) {
            return null;
        }

        if (!hs.isEmpty()) return null;

        return root;
    }

    public boolean dfs(TreeNode root, long min, long max,
                       HashMap<Integer, TreeNode> hs) {
        if (root == null) return true;

        if (root.val <= min || root.val >= max) {
            return false;
        }

        if (root.left == null && root.right == null
                && hs.containsKey(root.val)) {
            TreeNode localroot = hs.remove(root.val);
            root.left = localroot.left;
            root.right = localroot.right;
        }

        return dfs(root.left, min, root.val, hs)
            && dfs(root.right, root.val, max, hs);
    }
}
