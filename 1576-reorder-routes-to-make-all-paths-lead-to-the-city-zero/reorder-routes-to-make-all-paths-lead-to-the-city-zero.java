class Solution {
    public int minReorder(int n, int[][] connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < connections.length; i++) {
            int u = connections[i][0];
            int v = connections[i][1];
            adj.get(u).add(v);
        }
        ArrayList<ArrayList<Integer>> undir = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            undir.add(new ArrayList<>());
        }

        for (int i = 0; i < connections.length; i++) {
            int u = connections[i][0];
            int v = connections[i][1];
            undir.get(u).add(v);
            undir.get(v).add(u);
        }
        Stack<Integer> q = new Stack<>();

        q.add(0);
        int ans = 0;
        boolean[] visited = new boolean[n];
        while (!q.isEmpty()) {
            int a = q.pop();
            visited[a] = true;
            for (int neighb : undir.get(a)) {
                for (int actualNeighb : adj.get(a)) {
                    if (actualNeighb == neighb && !visited[actualNeighb])
                        ans++;

                }
                if (!visited[neighb])
                    q.push(neighb);
            }
        }
        return ans;
    }
}