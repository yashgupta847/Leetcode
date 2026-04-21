class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] swap : allowedSwaps) {
            int a = swap[0];
            int b = swap[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        boolean[] visited = new boolean[n];
        int result = 0;

        // Step 2: find components
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {

                // get one component
                ArrayList<Integer> comp = new ArrayList<>();
                dfs(i, adj, visited, comp);
                HashMap<Integer, Integer> map = new HashMap<>();

                for (int idx : comp) {
                    map.put(source[idx], map.getOrDefault(source[idx], 0) + 1);
                }
                for (int idx : comp) {
                    if (map.getOrDefault(target[idx], 0) > 0) {
                        map.put(target[idx], map.get(target[idx]) - 1);
                    } else {
                        result++;
                    }
                }
            }
        }

        return result;
    }

    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> comp) {
        visited[node] = true;
        comp.add(node);

        for (int nei : adj.get(node)) {
            if (!visited[nei]) {
                dfs(nei, adj, visited, comp);
            }
        }
    }
}