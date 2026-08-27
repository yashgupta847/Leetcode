class Solution {
    public ArrayList<Integer> upf(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                ans.add(i);
                while (n % i == 0) {
                    n /= i;
                }
            }
        }
        if (n > 1)
            ans.add(n);
        return ans;
    }

    public int longestSubarray(int[] nums, int k) {
        ArrayList<Integer>[] ans = new ArrayList[nums.length];

        for (int i = 0; i < nums.length; i++) {
            ans[i] = upf(nums[i]);
        }
        int l = 0;
        int r = 0;
        int len = 0;
        HashMap<Integer, Integer> hs = new HashMap<>();
        while (r < nums.length) {
            for (int p : ans[r]) {
                hs.put(p, hs.getOrDefault(p, 0) + 1);
            }

            while (hs.size() > k) {

                for (int p : ans[l]) {
                    hs.put(p, hs.get(p) - 1);

                    if (hs.get(p) == 0) {
                        hs.remove(p);
                    }
                }

                l++;
            }

            len = Math.max(len, r - l + 1);
            r++;
        }
        return len;
    }
}