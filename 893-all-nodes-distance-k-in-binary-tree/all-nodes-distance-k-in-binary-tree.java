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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashSet<TreeNode> hs = new HashSet<>();
        HashMap<TreeNode , TreeNode> map = new HashMap<>();
        // hs.add(root);
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size ;i++){
                TreeNode a = q.remove();
                if(a.left != null){
                    q.add(a.left);
                    map.put(a.left , a);
                }if(a.right != null){
                    q.add(a.right);
                    map.put(a.right , a);
                }
            }
        }
        int steps = 0;
        hs.add(target);
        q.add(target);
        while(steps != k){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                TreeNode a = q.remove();
                hs.add(a);
                if(a.left != null && !hs.contains(a.left)){
                    q.add(a.left);
                    hs.add(a.left);
                } if(a.right != null && !hs.contains(a.right)){
                    q.add(a.right);
                    hs.add(a.right);
                } if(map.get(a) != null && !hs.contains(map.get(a))){
                    q.add(map.get(a));
                    hs.add(map.get(a));
                }
            }
            steps++;
        }
        while(!q.isEmpty()){
            ans.add(q.remove().val);
        }
        return ans;
    }
}