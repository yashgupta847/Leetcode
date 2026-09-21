class Solution {
    public int f(int[][] matrix, int i, int j, int[][] dirs, int[][] dp) {

        if (dp[i][j] != -1)
            return dp[i][j];

        int ans = 1;

        for (int[] dir : dirs) {

            int nx = i + dir[0];
            int ny = j + dir[1];

            if (nx >= 0 && ny >= 0 &&
                    nx < matrix.length && ny < matrix[0].length &&
                    matrix[nx][ny] > matrix[i][j]) {

                ans = Math.max(ans,
                        1 + f(matrix, nx, ny, dirs, dp));
            }
        }

        return dp[i][j] = ans;
    }

    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        int[][] inD = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                for(int[] dirs : dir){
                    int nx = i + dirs[0];
                    int ny = j + dirs[1];
                    if(nx >= 0 && ny >= 0 && nx < n && ny < m && matrix[nx][ny] > matrix[i][j]){
                        inD[nx][ny]++;
                    }
                }
            }
        }
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(inD[i][j] == 0) q.add(new int[]{i , j});
            }
        }
        int ans = 0;
        while(!q.isEmpty()){
            int size = q.size();
            ans++;
            while(size-->0){
                int[] element = q.remove();
                int x = element[0];
                int y = element[1];
                for(int[] dirs : dir){
                    int nx = x + dirs[0];
                    int ny = y + dirs[1];
                    if(nx >= 0 && ny >= 0 && nx < n && ny < m && matrix[nx][ny] > matrix[x][y]) { inD[nx][ny]--; if(inD[nx][ny] == 0)q.add(new int[]{nx , ny});
                    }
                }
            }
        }
        return ans;
    }
}