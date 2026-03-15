class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int l = 0;
        int r = 0;
        int ans = 0;
        while (r < nums.length) {
            if (r < nums.length && nums[r] == 0) {
                l = r;
                l++;
            }            
            ans = Math.max(ans, r - l + 1);
            r++;

        }
        return ans;
    }
}