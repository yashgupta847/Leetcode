class Solution {
    public long mod = 1000000007;

    public long power(long base, long exp) {
        if (exp == 0)
            return 1;

        long half = power(base, exp / 2);

        if (exp % 2 == 0) {
            return (half * half) % mod;
        } else {
            return (half * half % mod * base) % mod;
        }
    }

    public int countGoodNumbers(long n) {
        long even = (n + 1) / 2;
        long odd = n / 2;

        long ans = (power(5, even) * power(4, odd)) % mod;
        return (int) ans;
    }
}