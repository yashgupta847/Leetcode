class Solution {
    public boolean prime(int i) {
        // int 
        if (i <= 1) return false;
        for (int j = 2; j < i; j++) {
            if(i % j == 0)
                return false;
        }
        return true;
    }

    public int sumOfPrimesInRange(int n) {
        int r = 0;
        int actual = n;
        while (n != 0) {
            int remainder = n % 10;
            r = r * 10 + remainder;
            n /= 10;
        }
        int max = Math.max(r, actual);
        int min = Math.min(r, actual);
        int sum = 0;
        for (int i = min; i <= max; i++) {
            if (prime(i))
                sum += i;
        }
        return sum;

    }
}