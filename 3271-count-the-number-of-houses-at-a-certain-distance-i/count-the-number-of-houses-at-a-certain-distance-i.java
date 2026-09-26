class Solution {
    public int[] countOfPairs(int n, int x, int y) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            adj.get(i).add(i + 1);
            adj.get(i + 1).add(i);
        }
        adj.get(x).add(y);
        adj.get(y).add(x);
        ArrayList<ArrayList<int[]>> ans = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            ans.add(new ArrayList<>());
        }
        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n + 1];
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[] { i, 0 });
            visited[i] = true;
            while (!q.isEmpty()) {
                int[] element = q.remove();
                int node = element[0];
                int dist = element[1];
                for (int neighb : adj.get(node)) {
                    if (!visited[neighb]) {
                        visited[neighb] = true;
                        q.add(new int[] { neighb, dist + 1 });
                        ans.get(i).add(new int[] { neighb, dist + 1 });
                    }
                }
            }
        }
        int[] and = new int[n];
        for (int i = 1; i <= n; i++) {
            for (int[] adjacent : ans.get(i)) {
                int dist = adjacent[1];
                and[dist-1]++;
            }
        }
        return and;
    }
}