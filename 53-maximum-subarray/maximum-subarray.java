// class Solution {
//     public int maxSubArray(int[] nums) {

//     }
// }
class Solution {
    public int maxSubArray(int[] nums) {
        int ans2 = Integer.MIN_VALUE;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += nums[i];
            ans2 = Math.max(ans2, ans);
            if (ans < 0)
                ans = 0;
        }
        return ans2;
    }
}