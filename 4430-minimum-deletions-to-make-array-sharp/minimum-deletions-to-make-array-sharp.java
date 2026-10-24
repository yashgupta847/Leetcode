class Solution {
    public int minDeletions(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                count++;
                i++;
            }

            ans += count - 1;

        }
        return ans;
    }
}