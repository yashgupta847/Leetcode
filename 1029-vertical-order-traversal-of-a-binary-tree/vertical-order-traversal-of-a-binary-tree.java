class Solution {
    class Pair {
        TreeNode n;
        int row, col;
        Pair(TreeNode n, int row, int col) {
            this.n = n;
            this.row = row;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> hs
            = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0, 0));
        while (!q.isEmpty()) {
            Pair p = q.remove();
            TreeNode n = p.n;
            int row = p.row;
            int col = p.col;
            hs.putIfAbsent(col, new TreeMap<>());
            hs.get(col).putIfAbsent(row, new PriorityQueue<>());
            hs.get(col).get(row).offer(n.val);
            if (n.left != null) {
                q.add(new Pair(n.left, row + 1, col - 1));
            }
            if (n.right != null) {
                q.add(new Pair(n.right, row + 1, col + 1));
            }
        }
        for (TreeMap<Integer, PriorityQueue<Integer>> rows : hs.values()) {
            List<Integer> column = new ArrayList<>();
            for (PriorityQueue<Integer> values : rows.values()) {
                while (!values.isEmpty()) {
                    column.add(values.poll());
                }
            }
            ans.add(column);
        }
        return ans;
    }
}