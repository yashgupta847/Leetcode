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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {

                TreeNode a = q.remove(); 
                if (i == size - 1) {
                    ans.add(a.val);
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
/* Structure of Binary Tree Node
class Node {
	int data;
	Node left, right;
	
	Node(int val) {
		this.data = val;
		this.left = this.right = null;
	}
} */

// class Solution {
// 	public ArrayList<Integer> leftView(Node root) {
// 		// code here
// 		Queue<Node> q = new LinkedList<>();
// 		ArrayList<Integer> adj = new ArrayList<>();
// 		if(root == null) return adj;
// 		q.add(root);
// 		while (!q.isEmpty()) {
// 			int size = q.size();
// 			for (int i = 0 ; i < size ; i++) {

// 				Node a = q.remove();
// 				if (i == 0) {
// 					adj.add(a.data);
// 				}
// 				if (a.left != null) {
// 					q.add(a.left);
// 				} if (a.right != null) {
// 					q.add(a.right);
// 				}
// 			}

// 		}
// 		return adj;
// 	}
// }
