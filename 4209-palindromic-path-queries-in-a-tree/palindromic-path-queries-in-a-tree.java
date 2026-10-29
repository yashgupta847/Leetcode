class Solution {
    List<Integer>[] g;
    int[][] parent;
    int[] in, out, bit, mask;
    int timer = 0, LOG;
    void updateBIT(int idx, int val, int n) {
        for (; idx <= n; idx += idx & -idx)
            bit[idx] ^= val;
    }
    int queryBIT(int idx) {
        int res = 0;
        for (; idx > 0; idx -= idx & -idx)
            res ^= bit[idx];
        return res;
    }

    void dfs(int u, int p) {
        in[u] = ++timer;
        parent[u][0] = p;

        for (int i = 1; i <= LOG; i++)
            parent[u][i] = parent[parent[u][i - 1]][i - 1];

        for (int v : g[u]) {
            if (v != p)
                dfs(v, u);
        }

        out[u] = timer;
    }

    boolean isAncestor(int u, int v) {
        return in[u] <= in[v] && out[u] >= out[v];
    }

    int lca(int u, int v) {
        if (isAncestor(u, v)) return u;
        if (isAncestor(v, u)) return v;

        for (int i = LOG; i >= 0; i--) {
            if (!isAncestor(parent[u][i], v))
                u = parent[u][i];
        }
        return parent[u][0];
    }

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {

        g = new ArrayList[n];
        for (int i = 0; i < n; i++)
            g[i] = new ArrayList<>();

        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        LOG = 0;
        while ((1 << (LOG + 1)) <= n) LOG++;

        parent = new int[n][LOG + 1];
        in = new int[n];
        out = new int[n];
        bit = new int[n + 1];
        mask = new int[n];

        dfs(0, 0);

        for (int i = 0; i < n; i++) {
            mask[i] = 1 << (s.charAt(i) - 'a');
            updateBIT(in[i], mask[i], n);
            updateBIT(out[i] + 1, mask[i], n);
        }

        List<Boolean> result = new ArrayList<>();

        for (String query : queries) {
            String[] parts = query.split(" ");

            if (parts[0].equals("update")) {

                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);

                int newMask = 1 << (c - 'a');
                int diff = mask[u] ^ newMask;

                updateBIT(in[u], diff, n);
                updateBIT(out[u] + 1, diff, n);

                mask[u] = newMask;

            } else {

                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                int l = lca(u, v);

                int pathMask = queryBIT(in[u]) ^ queryBIT(in[v]) ^ mask[l];

                result.add((pathMask & (pathMask - 1)) == 0);
            }
        }
        return result;
    }
}