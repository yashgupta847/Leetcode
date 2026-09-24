class Solution {
    class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int findParent(int node) {
            if (parent[node] == node)
                return node;
            int parentNode = findParent(parent[node]);
            return parent[node] = parentNode;
        }

        int union(int u, int v) {
            int parentu = findParent(u);
            int parentv = findParent(v);
            if (parentu == parentv)
                return 0;

            if (rank[parentu] > rank[parentv]) {
                parent[parentv] = parentu;

            } else if (rank[parentu] < rank[parentv]) {
                parent[parentu] = parentv;
            } else {
                parent[parentv] = parentu;
                rank[parentu]++;
            }
            return 1;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int[] ans = new int[2];
        DSU ds = new DSU(edges.length);
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            if (ds.union(u, v) == 0) {
                ans[0] = u;
                ans[1] = v;
            }
        }
        return ans;
    }
}