class Solution {
    class DSU {
        int[] rank;
        int[] parent;

        DSU(int n) {
            rank = new int[n];
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                rank[i] = 0;
                parent[i] = i;
            }
        }

        public int parent(int node) {
            if (parent[node] == node) {
                return node;
            }
            int pU = parent(parent[node]);
            return parent[node] = pU;
        }

        public int union(int u, int v) {
            int parentU = parent(u);
            int parentV = parent(v);
            if (parentU == parentV) {
                return 1;
            }
            if (rank[parentU] > rank[parentV]) {
                parent[parentV] = parentU;
            } else if (rank[parentU] < rank[parentV]) {
                parent[parentU] = parentV;
            } else {
                rank[parentU]++;
                parent[parentV] = parentU;
            }
            return 0;

        }
    }

    public int makeConnected(int n, int[][] connections) {
        DSU ds = new DSU(n);
        int internalextra = 0;
        for (int i = 0; i < connections.length; i++) {
            internalextra += ds.union(connections[i][0], connections[i][1]);
        }
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (ds.parent[i] == i)
                components++;
        }
        if (internalextra >= components - 1)
            return components - 1;
        return -1;
    }
}