class Solution {
    public int[] nextGreaterElements(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            arr.add(nums[i]);
        }
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            boolean yes = false;
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(i) < arr.get(j)) {
                    ans[idx] = (arr.get(j));
                    yes = true;
                    idx++;
                    break;

                }
            }
            if (!yes) {
                ans[idx] = (-1);
                idx++;
            }
        }
        return ans;
    }
}