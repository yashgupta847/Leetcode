class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long l = 1;
        long r = 0;
        for (int i = 0; i < workerTimes.length; i++) {
            r = Math.max(r, workerTimes[i]);
        }
        long ans = 0;
        r *= (long)mountainHeight * (mountainHeight + 1) / 2;
        while (l <= r) {
            long i = (l + r) / 2;
            int h = 0;
            for (int j = 0; j < workerTimes.length; j++) {
                long time = 0;
                for (int k = 1; k <= mountainHeight; k++) {
                    if (time + (long) workerTimes[j] * k <= i) {
                        h++;
                        time += (long)workerTimes[j] * k;
                    } else
                        break;
                }
                if (h >= mountainHeight)
                    break;
            }
            if (h >= mountainHeight) {
                ans = i;
                r = i - 1;
            } else
                l = i + 1;
        }
        return ans;
    }
}