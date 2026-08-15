class Solution {
    public String getPermutation(int n, int k) {

        String ans = "";
        int fact = 1;
        ArrayList<Integer> adj = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            fact *= i;
            adj.add(i);
        }
        fact = fact / n;
        k = k - 1;
        while (true) {
            ans += adj.get(k / fact);
            adj.remove((k / fact));
            if (adj.size() == 0)
                return ans;
            k = k % fact;
            fact = fact / adj.size();
        }
    }
}