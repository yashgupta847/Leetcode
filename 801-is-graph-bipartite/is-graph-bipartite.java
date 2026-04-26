class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                q.add(new int[] { i, 0 });
                color[i] = 0;
                while (!q.isEmpty()) {
                    int[] a = q.poll();
                    int ele = a[0];
                    int prevColor = a[1];
                    for (int neigh : graph[ele]) {
                        if (color[neigh] == prevColor) {
                            return false;
                        } else if (color[neigh] == -1) {
                            color[neigh] = prevColor == 0 ? 1 : 0;
                            q.add(new int[] { neigh, color[neigh] });
                        }
                    }
                }
            }
        }
        return true;
    }

}