class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        for (int[] m : mat) {
            Arrays.sort(m);
        }
        int index = 0;
        int ans = 0;
        for (int i = 0; i < mat.length; i++) {
            int l = 0;
            int r = mat[0].length - 1;
            int idx = -1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (mat[i][mid] == 1) {
                    r = mid - 1;
                    idx = mid;
                } else if (mat[i][mid] == 0)
                    l = mid + 1;
            }
            int one = -1;
            if (idx != -1)
                one = mat[0].length - idx;
            if (one > ans) {
                ans = one;
                index = i;
            }
        }
        return new int[] { index, ans };
    }
}