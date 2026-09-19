class Solution {
    class DSU {
        int[] parent;
        int[] rank;
        int[] size;

        public DSU(int n, int m) {
            parent = new int[n * m];
            rank = new int[n * m];
            size = new int[n * m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int node = i * m + j;
                    parent[node] = i * m + j;
                    rank[node] = 0;
                    size[node] = 1;
                }
            }
        }

        public void union(int u, int v) {
            int parentU = findParent(u);
            int parentV = findParent(v);
            if (parentU == parentV)
                return;
            if (rank[parentU] > rank[parentV]) {
                parent[parentV] = parentU;
                size[parentU] += size[parentV];
            } else if (rank[parentU] < rank[parentV]) {
                parent[parentU] = parentV;
                size[parentV] += size[parentU];
            } else {
                rank[parentU]++;
                parent[parentV] = parentU;
                size[parentU] += size[parentV];
            }
        }

        public int findParent(int node) {
            if (parent[node] == node)
                return node;
            int parentU = findParent(parent[node]);
            return parent[node] = parentU;
        }
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        int zeroCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0)
                    zeroCount++;
            }
        }
        if (zeroCount == n * m)
            return 1;
        if (zeroCount == 0)
            return n * m;
        DSU dsu = new DSU(n, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    for (int[] dir : dirs) {
                        int nx = i + dir[0];
                        int ny = j + dir[1];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 1) {
                            dsu.union(i * m + j, nx * m + ny);
                        }
                    }
                }
            }
        }
        int actualAns = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                HashSet<Integer> hs = new HashSet<>();
                int ans = 1;
                if (grid[i][j] == 0) {

                    for (int[] dir : dirs) {
                        int nx = dir[0] + i;
                        int ny = dir[1] + j;
                        if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 1)
                            hs.add(dsu.findParent(nx * m + ny));
                    }
                }
                while (!hs.isEmpty()) {
                    int element = hs.iterator().next();
                    ans += dsu.size[element];
                    hs.remove(element);
                }
                actualAns = Math.max(ans, actualAns);

            }
        }
        return actualAns;
    }
}