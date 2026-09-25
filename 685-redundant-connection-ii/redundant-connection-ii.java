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

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] ans = new int[2];
        ArrayList<ArrayList<Integer>> parents = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < edges.length + 1; i++) {
            parents.add(new ArrayList<>());
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            parents.get(v).add(u);
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
        }
        boolean yes = false;
        int[] candidate1 = new int[2];
        int[] candidate2 = new int[2];
        for (int i = 0; i < parents.size(); i++) {
            if (parents.get(i).size() > 1) {
                candidate1[0] = parents.get(i).get(0);
                candidate1[1] = i;
                candidate2[0] = parents.get(i).get(1);
                candidate2[1] = i;
                yes = true;
                break;
            }
        }

        if (yes) {
            DSU ds = new DSU(edges.length);
            for (int i = 0; i < edges.length; i++) {
                int u = edges[i][0];
                int v = edges[i][1];
                if (u == candidate2[0] && v == candidate2[1]) {
                    continue;
                }
                if (ds.union(u, v) == 0) {
                    return candidate1;
                }
            }
            return candidate2;
        }

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