class Solution {
    public int sumCounts(List<Integer> nums) {
        int ans = 0;
        for (int i = 0; i < nums.size(); i++) {
            HashSet<Integer> hs = new HashSet<>();
            hs.add(nums.get(i));
            for (int j = i; j < nums.size(); j++) {
                hs.add(nums.get(j));
                ans += hs.size() * hs.size();
            }

        }
        // HashSet<Integer> hs1 = new HashSet<>();
        // for (int i = 0; i < nums.size(); i++) {
        //     hs1.add(nums.get(i));
        // }
        return ans;
    }
}