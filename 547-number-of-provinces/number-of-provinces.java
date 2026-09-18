class Solution {
    class DSU {
        int[] parent;
        int[] rank;

        public DSU(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int findParent(int node) {
            if (parent[node] == node) {
                return node;
            }
            int pU = findParent(parent[node]);
            return parent[node] = pU;
        }

        void union(int u, int v) {
            int parentU = findParent(u);
            int parentV = findParent(v);
            if (parentU == parentV)
                return;
            if (rank[parentU] > rank[parentV]) {
                parent[parentV] = parentU;
            } else if (rank[parentV] > rank[parentU]) {
                parent[parentU] = parentV;
            } else {
                rank[parentU]++;
                parent[parentV] = parentU;
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        DSU ds = new DSU(isConnected.length );
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1) {
                    ds.union(i+1, j+1);
                }
            }
        }
        int ans = 0;
        for(int i = 1 ; i < isConnected.length+1 ;i++){
            if(ds.parent[i] == i) ans++;
        }
        return ans;
    }
}