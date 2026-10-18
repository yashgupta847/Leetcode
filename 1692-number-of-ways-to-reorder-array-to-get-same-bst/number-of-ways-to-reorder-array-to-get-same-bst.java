
import java.util.*;

class Solution {
    static final long MOD = 1000000007L;

    public long power(long a, long b) {
        long ans = 1;

        while (b > 0) {
            if (b % 2 == 1) {
                ans = ans * a % MOD;
            }

            a = a * a % MOD;
            b /= 2;
        }

        return ans;
    }

    long[] fact;
    long[] invFact;

    public void precompute(int n) {
        fact = new long[n + 1];
        invFact = new long[n + 1];

        fact[0] = 1;

        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        invFact[n] = power(fact[n], MOD - 2);

        for (int i = n; i >= 1; i--) {
            invFact[i - 1] = invFact[i] * i % MOD;
        }
    }

    public long f(ArrayList<Integer> nums) {
        if (nums.size() <= 1) {
            return 1;
        }

        ArrayList<Integer> choti = new ArrayList<>();
        ArrayList<Integer> badi = new ArrayList<>();

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) > nums.get(0)) {
                badi.add(nums.get(i));
            } else {
                choti.add(nums.get(i));
            }
        }

        int chota = choti.size();
        int bada = badi.size();

        long leftWays = f(choti);
        long rightWays = f(badi);

        long ways = fact[chota + bada]
                  * invFact[chota] % MOD
                  * invFact[bada] % MOD;

        long ans = ways * leftWays % MOD;
        ans = ans * rightWays % MOD;

        return ans;
    }

    public int numOfWays(int[] nums) {
        precompute(nums.length);

        ArrayList<Integer> list = new ArrayList<>();

        for (int num : nums) {
            list.add(num);
        }

        return (int) ((f(list) - 1 + MOD) % MOD);
    }
}
