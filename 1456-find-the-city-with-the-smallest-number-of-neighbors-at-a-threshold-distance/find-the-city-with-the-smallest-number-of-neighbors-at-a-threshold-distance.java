class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] mat = new int[n][n];
        for (int[] mat0 : mat) {
            Arrays.fill(mat0, Integer.MAX_VALUE);
        }
        for (int[] edge : edges) {
            int i = edge[0];
            int j = edge[1];
            mat[i][j] = edge[2];
            mat[j][i] = edge[2];
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][k] != Integer.MAX_VALUE && mat[k][j] != Integer.MAX_VALUE)
                        if (mat[i][j] > mat[i][k] + mat[k][j]) {
                            mat[i][j] = mat[i][k] + mat[k][j];
                        }
                }
            }
        }
        int now = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < n; i++) {
            int ans = 0;
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                if (mat[i][j] <= distanceThreshold) {
                    ans++;
                }
            }
            if (ans <= now) {
                now = ans;
                index = i;
            }

        }
        return index;
    }
}