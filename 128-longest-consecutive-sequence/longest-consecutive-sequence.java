class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int x : nums)
            hs.add(x);
        int ans = 0;
        for (int x : hs) {
            if (!hs.contains(x - 1)) {
                int curr = x;
                int len = 1;
                while (hs.contains(curr + 1)) {
                    curr++;
                    len++;
                }
                ans = Math.max(ans, len);
            }

        }
        return ans;
    }
}