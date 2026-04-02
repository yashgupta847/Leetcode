class Solution {
    public int[] findPeakGrid(int[][] mat) {
        if(mat.length == 1 && mat[0].length == 1) return new int[]{0,0};
        int l = 1;
        int r = mat[0].length - 2;
        int idx1 = -1;
        int max1 = Integer.MIN_VALUE;
        for (int i = 0; i < mat.length; i++) {
            if (max1 < mat[i][0]) {
                max1 = mat[i][0];
                idx1 = i;
            }
        }
        if(mat[0].length == 1) return new int[]{idx1 , 0};
        if (mat[idx1][0] > mat[idx1][1])
            return new int[] { idx1, 0 };
        int idx2 = -1;
        int max2 = Integer.MIN_VALUE;
        for (int i = 0; i < mat.length; i++) {
            if (max2 < mat[i][mat[0].length - 1]) {
                max2 = mat[i][mat[0].length - 1];
                idx2 = i;
            }
        }
        if (mat[idx2][mat[0].length - 1] > mat[idx2][mat[0].length - 2])
            return new int[] { idx2, mat[0].length - 1 };

        while (l <= r) {
            int mid = (l + r) / 2;
            int max = Integer.MIN_VALUE;
            int idx = -1;
            for (int i = 0; i < mat.length; i++) {
                if (mat[i][mid] > max) {
                    max = mat[i][mid];
                    idx = i;
                }
            }
            if (mat[idx][mid] > mat[idx][mid - 1] && mat[idx][mid] > mat[idx][mid + 1]) {
                return new int[] { idx, mid };
            } else if (mat[idx][mid] < mat[idx][mid - 1]) {
                r = mid - 1;
            } else
                l = mid + 1;

        }
        return new int[] { -1, -1 };
    }
}