class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = Integer.MIN_VALUE;
        int r = 0;
        for (int i = 0; i < weights.length; i++) {
            l = Math.max(l, weights[i]);
            r += weights[i];
        }
        int ans = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = (l + r) / 2;
            int d = days;
            int i = 0;
            while (i<weights.length) {
                int cnt = 0;
                while (i < weights.length && cnt+weights[i] <= mid) {
                    cnt += weights[i];
                    i++;
                }
                d--;
            }
            if (d >= 0) {
                ans = Math.min(ans, mid);
                r = mid - 1;
            } else
                l = mid + 1;
        }
        return ans;

    }
}