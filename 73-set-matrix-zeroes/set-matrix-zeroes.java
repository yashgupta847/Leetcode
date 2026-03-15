class Solution {
    public void setZeroes(int[][] matrix) {
        HashSet<String> hs = new HashSet<>();
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0)
                    hs.add(i + " " + j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0 && hs.contains(i + " " + j)) {
                    int k = 0;
                    while (k < m) {
                        matrix[i][k] = 0;
                        k++;
                    }
                    k = 0;
                    while (k < n) {
                        matrix[k][j] = 0;
                        k++;
                    }
                }
            }
        }
    }
}