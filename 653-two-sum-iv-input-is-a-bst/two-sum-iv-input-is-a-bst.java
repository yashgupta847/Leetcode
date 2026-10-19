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
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> adj = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode a= q.remove();
            adj.add(a.val);
            if(a.left!= null){
                q.add(a.left);
            }
            if(a.right != null){
                q.add(a.right);
            }
        }
        Collections.sort(adj);
        if(adj.size() == 1) return false;
        int l = 0;
        int r = adj.size()-1;
        while(l < r){
            int sum = adj.get(l) + adj.get(r);
            if(sum == k) return true;
            if(sum > k){
                r--;
            } if(sum < k){
                l++;
            }
        }
        return false;
    }
}