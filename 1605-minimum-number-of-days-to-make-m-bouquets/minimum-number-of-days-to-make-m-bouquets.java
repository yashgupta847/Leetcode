class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;
        for (int i = 0; i < bloomDay.length; i++) {
            l = Math.min(l, bloomDay[i]);
            r = Math.max(r, bloomDay[i]);
        }
        int day = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int ans = 0;
            int count = 0;
            for (int i = 0; i < bloomDay.length; i++) {
                while (i < bloomDay.length && bloomDay[i] <= mid) {
                    ans++;
                    i++;
                }
                count += ans / k;
                ans = 0;
            }
            if (count >= m) {
                day = mid;
                r = mid - 1;
            } else
                l = mid + 1;
        }
        return day;
    }
}