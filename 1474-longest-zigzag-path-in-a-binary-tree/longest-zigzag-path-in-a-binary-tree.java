
class Solution {
    int ansactual = 0;

    public void f(TreeNode node, int leftDepth, int rightDepth) {
        if (node == null) return;

        ansactual = Math.max(ansactual, Math.max(leftDepth, rightDepth));

        if (node.left != null) {
            f(node.left, rightDepth + 1, 0);
        }

        if (node.right != null) {
            f(node.right, 0, leftDepth + 1);
        }
    }

    public int longestZigZag(TreeNode root) {
        f(root, 0, 0);
        return ansactual;
    }
}
