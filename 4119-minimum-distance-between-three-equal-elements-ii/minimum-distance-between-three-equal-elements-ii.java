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
                int l = 0;
                int r = 2;
                while(r < arr.size()){
                    ans = Math.min(ans, arr.get(r) - arr.get(l));
                    r++;
                    l++;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : 2 * ans;
    }
}