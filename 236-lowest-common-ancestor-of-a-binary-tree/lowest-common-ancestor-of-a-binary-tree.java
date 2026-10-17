/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean find(TreeNode target, ArrayList<TreeNode> paths, TreeNode root) {
        if (root == null)
            return false;
        paths.add(root);
        if (root == target) {
            return true;
        }
        if (find(target, paths, root.left))
            return true;
        if (find(target, paths, root.right))
            return true;

        paths.remove(paths.size() - 1);
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> pvalapath = new ArrayList<>();
        ArrayList<TreeNode> qvalapath = new ArrayList<>();
        find(p, pvalapath, root);
        find(q, qvalapath, root);
        int l = pvalapath.size() - 2;
        int r = qvalapath.size() - 2;
        for (int i = pvalapath.size() - 1; i >= 0; i--) {
            for (int j = qvalapath.size() - 1; j >= 0; j--) {
                if (pvalapath.get(i) == qvalapath.get(j)) {
                    return pvalapath.get(i);
                }
            }
        }
        return root;
    }
}