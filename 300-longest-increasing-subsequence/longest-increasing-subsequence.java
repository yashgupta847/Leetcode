class Solution {
    //     public int f(int[] nums, int idx, int prev, int[][] dp) {
    //         if (idx >= nums.length) {
    //             return 0;
    //         }
    //         if (dp[idx][prev + 1] != -1)
    //             return dp[idx][prev + 1];
    //         int len = f(nums, idx + 1, prev, dp); //notTake
    //         if (prev == -1 || (nums[idx] > nums[prev])) {
    //             len = Math.max(len, f(nums, idx + 1, idx, dp) + 1);
    //         }
    //         return dp[idx][prev + 1] = len;
    //     }

    public int lengthOfLIS(int[] nums) {
        //         // int[] dp = new int[nums.length];
        //         // Arrays.fill(dp, 1);
        //         // int max = 1;
        //         // // for (int[] dp1 : dp)
        //         // //     Arrays.fill(dp1, -1);
        //         // // return f(nums, 0, -1, dp);
        //         // for (int i = 0; i < nums.length; i++) {
        //         //     for (int j = 0; j <= i - 1; j++) {
        //         //         if (nums[i] > nums[j]) {
        //         //             dp[i] = Math.max(dp[i], 1 + dp[j]);
        //         //             // max = Math.max(max, dp[i]);
        //         //         }
        //         //     }
        //         // }

        //         // return max;

        //         //From Binary Search
        //         ArrayList<Integer> ans = new ArrayList<>();
        //         ans.add(nums[0]);
        //         for(int i = 1; i < nums.length ; i++){
        //             if(nums[i] > ans.get(ans.size()-1)){
        //                 ans.add(nums[i]);
        //             } else {
        //                 for(int j = 0 ; j < i ;j++){
        //                     if(ans.get(j) >= nums[i]) {
        //                         ans.set(j , nums[i]);
        //                         break;
        //                     }
        //                 }
        //             }
        //         }
        //         return ans.size();
        //     }
        // }

        int[] dp1 = new int[nums.length];
        // int[] dp2 = new int[nums.length];
        int n = nums.length;
        Arrays.fill(dp1, 1);
        // Arrays.fill(dp2, 1);        
        int ans = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp1[j] + 1 > dp1[i])
                    dp1[i] = 1 + dp1[j];
            }
            ans = Math.max(dp1[i], ans);
        }

        // for (int i = n - 2; i >= 0; i--) {
        //     for (int j = n - 1; j > i; j--) {
        //         if (nums[i] > nums[j] && dp2[j] + 1 > dp2[i])
        //             dp2[i] = 1 + dp2[j];
        //     }
        // }
        // for (int i = 1; i < n; i++) {
        //     ans = Math.max(dp1[i] + dp2[i], ans);
        // }
        return ans;
    }
}