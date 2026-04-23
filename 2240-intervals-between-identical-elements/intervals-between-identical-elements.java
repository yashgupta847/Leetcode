
class Solution {
    public long[] getDistances(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> hs = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hs.containsKey(nums[i])) {
                hs.get(nums[i]).add(i);
            } else {
                hs.put(nums[i], new ArrayList<>());
                hs.get(nums[i]).add(i);
            }
        }
        long[] ans = new long[nums.length];
        for(ArrayList<Integer> yuhu : hs.values()) {
            int k = yuhu.size();
            long[] prefix = new long[yuhu.size()];
            prefix[0] = yuhu.get(0);
            for (int j = 1; j < prefix.length; j++) {
                prefix[j] = prefix[j - 1] + yuhu.get(j);
            }
            for (int j = 0; j < yuhu.size(); j++) {

                int idx = yuhu.get(j);
                long left = (long) idx * j - (j > 0 ? prefix[j - 1] : 0);
                long right = (prefix[k - 1] - prefix[j]) - (long) idx * (k - j - 1);

                ans[idx] = left + right;
            }

        }
        return ans;
    }
}