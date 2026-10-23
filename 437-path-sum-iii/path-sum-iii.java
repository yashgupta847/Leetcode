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
    int ans = 0;

    public void f(TreeNode root, long sum, int target) {
        if (root == null)
            return;
        sum += root.val;
        if (sum == target)
            ans++;
        f(root.left, sum, target);
        f(root.right, sum, target);
    }

    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode a = st.pop();
            f(a , 0 , targetSum);
            if(a.left != null) st.push(a.left);
            if(a.right != null) st.push(a.right);
        }
        return ans;
    }
}
