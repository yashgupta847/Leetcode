class Solution {

    public int solve(int[] nums1, int[] nums2, int idx, int swap, int[][] dp) {
        if (idx == nums1.length)
            return 0;
        int prev1 = nums1[idx - 1];
        int prev2 = nums2[idx - 1];
        if (swap == 1) {
            int temp = prev1;
            prev1 = prev2;
            prev2 = temp;
        }
        if (dp[idx][swap] != -1)
            return dp[idx][swap];
        int ans = Integer.MAX_VALUE;
        //noswap
        if (nums1[idx] > prev1 && nums2[idx] > prev2) {
            ans = Math.min(ans,
                    solve(nums1, nums2, idx + 1, 0, dp));
        }
        //swap
        if (nums1[idx] > prev2 && nums2[idx] > prev1) {
            ans = Math.min(ans, 1 + solve(nums1, nums2, idx + 1, 1, dp));
        }
        return dp[idx][swap] = ans;
    }

    public int minSwap(int[] nums1, int[] nums2) {
        int[] nums1copy = new int[nums1.length + 1];
        int[] nums2copy = new int[nums2.length + 1];
        nums1copy[0] = -1;
        nums2copy[0] = -1;
        for (int i = 1; i < nums1copy.length; i++) {
            nums1copy[i] = nums1[i - 1];
            nums2copy[i] = nums2[i - 1];
        }
        int[][] dp = new int[nums1.length+1][2];
        for (int[] dp1 : dp)
            Arrays.fill(dp1, -1);
        return solve(nums1copy, nums2copy, 1, 0, dp);
    }
}