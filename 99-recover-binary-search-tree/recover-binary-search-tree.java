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
// class Solution {
//     public void inorder(TreeNode root ,ArrayList<TreeNode> adj){
//         if(root == null) return ;
//         inorder(root.left , adj);
//         adj.add(root);
//         inorder(root.right , adj);
//     }
//     public void recoverTree(TreeNode root) {
//         ArrayList<TreeNode> adj = new ArrayList<>();
//         Queue<TreeNode> queue = new LinkedList<>();
        
//         inorder(root , adj);
//         int p = -1;
//         int q = -1;
//         boolean found = false;
//         for (int i = 0; i < adj.size() && !found; i++) {
//             for (int j = i + 1; j < adj.size() && !found; j++) {
//                 if (adj.get(i).val > adj.get(j).val) {
//                     p = i;
//                     q = j;
//                     found = true;
//                     break;

//                 }
//             }
//         }
//         TreeNode a = adj.get(p);
//         TreeNode b = adj.get(q);
//         int temp = a.val;
//         a.val = b.val;
//         b.val = temp;
//     }
// }

class Solution {
    public void inorder(TreeNode root, ArrayList<TreeNode> adj) {
        if (root == null) return;

        inorder(root.left, adj);
        adj.add(root);
        inorder(root.right, adj);
    }

    public void recoverTree(TreeNode root) {
        ArrayList<TreeNode> adj = new ArrayList<>();

        inorder(root, adj);

        int p = -1;
        int q = -1;

        for (int i = 0; i < adj.size() - 1; i++) {
            if (adj.get(i).val > adj.get(i + 1).val) {
                if (p == -1) {
                    p = i;
                }
                q = i + 1;
            }
        }

        if (p != -1 && q != -1) {
            TreeNode a = adj.get(p);
            TreeNode b = adj.get(q);

            int temp = a.val;
            a.val = b.val;
            b.val = temp;
        }
    }
}
