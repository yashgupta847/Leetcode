class Solution {
    public void reverse(int[][] mat2, int l, int r , int i) {
        int temp;
        while (l <= r) {
            temp = mat2[i][l];
            mat2[i][l] = mat2[i][r];
            mat2[i][r] = temp;
            l++;
            r--;
        }
    }

    public boolean areSimilar(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;

        if (k > m)
            k = k % m;
        if (k == 0)
            return true;
        int[][] mat2 = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat2[i][j] = mat[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            int l = 0;
            int r = m - 1;
            if (i % 2 == 0) {
                l = 0;
                r = k - 1;
                reverse(mat2, l, r , i);
                l = k;
                r = m - 1;
                reverse(mat2, l, r , i);
                l = 0;
                r = m - 1;
                reverse(mat2, l, r , i);
            } else {
                l = 0;
                r = m - k - 1;
                int temp;
                reverse(mat2, l, r , i);
                l = m - k;
                r = m - 1;
                reverse(mat2, l, r , i);
                l = 0;
                r = m - 1;
                reverse(mat2, l, r , i);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] != mat2[i][j])
                    return false;
            }
        }
        return true;

    }
}