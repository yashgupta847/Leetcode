class Solution {
    public int countPrimes(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        for (int i = 2; i * i < prime.length; i++) {
            if (prime[i] == true) {
                for (int j = i * i; j < prime.length; j += i) {
                    prime[j] = false;
                }
            }
        }
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (prime[i] == true)
                ans++;
        }
        return ans;
    }
}