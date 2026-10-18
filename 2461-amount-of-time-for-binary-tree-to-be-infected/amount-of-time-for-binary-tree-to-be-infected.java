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
    public int amountOfTime(TreeNode root, int start) {
        Queue<TreeNode> q= new LinkedList<>();
        HashMap<TreeNode , TreeNode> map = new HashMap<>();
        q.add(root); 
        TreeNode t = null;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                TreeNode a = q.remove();
                if(a.val == start){
                    t = a;
                }
                if(a.left != null){
                    q.add(a.left);
                    map.put(a.left , a);
                } if(a.right != null){
                    q.add(a.right);
                    map.put(a.right , a);
                }
            }
        }
        q.clear();
        HashSet<Integer> hs = new HashSet<>();
        hs.add(start);
        q.add(t);
        int time = -1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                TreeNode a = q.remove();
                if(a.left != null && !hs.contains(a.left.val)){
                    hs.add(a.left.val);
                    q.add(a.left);
                } if(a.right != null && !hs.contains(a.right.val)){
                    hs.add(a.right.val);
                    q.add(a.right);
                } if(map.get(a) != null && !hs.contains(map.get(a).val)){
                    hs.add(map.get(a).val);
                    q.add(map.get(a));
                }
            }
            time++;
        }
        return time;
    }
}