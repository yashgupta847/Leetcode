class Solution {
    public int dfs(int i, ArrayList<ArrayList<Integer>> adj, int parent) {
        int height = 0;
        for (int nei : adj.get(i)) {
            if (nei != parent) {
                height = Math.max(height, 1 + dfs(nei, adj, i));
            }
        }
        return height;
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        Queue<Integer> q = new LinkedList<>();
        int[] degree = new int[n];
        for (int i = 0; i < n; i++) {
            degree[i] = adj.get(i).size();
            if (degree[i] == 1)
                q.add(i);
        }
        List<Integer> ans = new ArrayList<>();
        if (n == 1) {
            ans.add(0);
            return ans;
        }
        int remaining = n;
        while (remaining > 2) {
            int size = q.size();
            remaining -= size;

            while (size-- > 0) {
                int node = q.remove();
                for (int neighb : adj.get(node)) {
                    degree[neighb]--;
                    if (degree[neighb] == 1) {
                        q.add(neighb);
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            ans.add(q.remove());
        }
        return ans;

    }
}