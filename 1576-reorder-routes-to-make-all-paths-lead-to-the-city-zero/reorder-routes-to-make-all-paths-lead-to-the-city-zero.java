class Solution {
    public int minReorder(int n, int[][] connections) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < connections.length; i++) {
            int u = connections[i][0];
            int v = connections[i][1];
            adj.get(u).add(new int[] { v, 1 });
            adj.get(v).add(new int[] { u, 0 });
        }

        Stack<Integer> q = new Stack<>();
        q.add(0);
        int ans = 0;
        boolean[] visited = new boolean[n];
        while (!q.isEmpty()) {
            int a = q.pop();
            visited[a] = true;
            for (int[] neighb : adj.get(a)) {
                int neigh = neighb[0];
                int cost = neighb[1];
                if(!visited[neigh]){
                    q.add(neigh);
                    ans += cost;
                }
            }
        }
        return ans;
    }
}