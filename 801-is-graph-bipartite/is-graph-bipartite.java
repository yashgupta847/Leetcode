class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                q.add(i);
                visited[i] = true;
                color[i] = 1;
                while (!q.isEmpty()) {
                    int a = q.remove();
                    for (int j = 0; j < graph[a].length; j++) {
                        if (!visited[graph[a][j]]) {
                            visited[graph[a][j]] = true;
                            q.add(graph[a][j]);
                            if (color[a] == 1) {
                                color[graph[a][j]] = 0;

                            } else
                                color[graph[a][j]] = 1;
                        } else if (visited[graph[a][j]]) {
                            if (color[a] == color[graph[a][j]])
                                return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}