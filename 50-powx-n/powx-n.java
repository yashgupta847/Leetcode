class Solution {
    public double f(double x, long n) {
        if (n == 0)
            return 1;
        double half = myPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public double myPow(double x, long n) {
        long N = n;
        if (n < 0) {
            N = -N;
            x = 1 / x;
        }
        return f(x, N);
    }
}