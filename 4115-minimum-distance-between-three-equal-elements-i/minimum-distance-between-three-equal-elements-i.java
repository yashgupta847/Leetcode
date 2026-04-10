class Solution {
    public int minimumDistance(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> hs = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hs.containsKey(nums[i])) {
                hs.get(nums[i]).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                hs.put(nums[i], list);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (ArrayList<Integer> arr : hs.values()) {
            if (arr.size() == 3)
                ans = Math.min(ans, Math.abs(arr.get(0) - arr.get(arr.size() - 1)));
            else if (arr.size() > 3) {
                for (int i = 0; i < arr.size() - 2; i++) {
                    ans = Math.min(ans, arr.get(i + 2) - arr.get(i));
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : 2 * ans;
    }
}