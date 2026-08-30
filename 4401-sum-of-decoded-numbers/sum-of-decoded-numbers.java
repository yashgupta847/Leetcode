class Solution {
    static final long MOD = 1_000_000_007;

    long power(long x, long y) {
        long res = 1;
        while (y > 0) {
            if ((y & 1) == 1) {
                res = (res * x) % 1_000_000_007;
            }

            x = (x * x) % 1_000_000_007;
            y /= 2;
        }
        return res;
    }
    public int sumDecoded(long[] nums) {
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            long a = nums[i];
            long w = a % 10;
            long d = a / 10;
            long div = 1;
            while (d / div >= 10) {
                div *= 10;
            }
            for (int j = 1; j < w; j++) {
                div /= 10;
            }
            long x = d / div;
            long y = d % div;
            ans = (ans + power(x, y)) % MOD;
        }
        return (int) ans;
    }
}