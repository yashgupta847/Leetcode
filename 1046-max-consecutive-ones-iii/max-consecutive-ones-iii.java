class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int zero = 0;
        int ans = 0;
        while (r < nums.length) {
            if (nums[r] == 0) {
                zero++;
            }
            if (zero <= k) {
                ans = Math.max(ans, r - l + 1);
            }
            if (zero > k) {
               
                if (nums[l] == 0) {
                    zero--;
                } 
                l++;
            }
            r++;
        }
        return ans;
    }
}