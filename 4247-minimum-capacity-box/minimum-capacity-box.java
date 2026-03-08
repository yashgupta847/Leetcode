class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
        int n = capacity.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = capacity[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        int l = 0, r = n - 1;
        int pos = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid][0] >= itemSize) {
                pos = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (pos == -1)
            return -1;
        int minCap = arr[pos][0];
        int ans = Integer.MAX_VALUE;
        for (int i = pos; i < n && arr[i][0] == minCap; i++) {
            ans = Math.min(ans, arr[i][1]);
        }
        return ans;
    }
}