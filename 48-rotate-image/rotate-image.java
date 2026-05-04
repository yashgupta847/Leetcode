class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = k; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
            k++;
        }
        int l = 0;
        int r = m - 1;
        while (l < r) {
            for (int i = 0; i < n; i++) {
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;
            }
            l++;
            r--;
        }
        // return matrix;
    }
}