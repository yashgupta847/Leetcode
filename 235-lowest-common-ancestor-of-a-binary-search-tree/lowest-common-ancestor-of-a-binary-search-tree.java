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
    ArrayList<TreeNode> pvala = new ArrayList<>();
    ArrayList<TreeNode> qvala = new ArrayList<>();
    public void paths(TreeNode root , TreeNode target , ArrayList<TreeNode> path){
        if(root == null) return;

        if(root == target){
            path.add(root);
            return;
        }
        if(root.val > target.val){
            path.add(root);
            paths(root.left , target , path);
        } if(root.val < target.val){
            path.add(root);
            paths(root.right , target , path);
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        paths(root , p , pvala);

        paths(root , q ,qvala);
        TreeNode ans = null;
        for(int i = 0 ; i < Math.min(pvala.size() , qvala.size()) ; i++){
            if(pvala.get(i) == qvala.get(i)){
                ans = pvala.get(i);
            }
        }
        return ans;
    }
}