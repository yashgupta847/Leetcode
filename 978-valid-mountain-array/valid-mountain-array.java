class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if (arr.length < 3)
            return false;
        // int[] dp = new int[arr.length];
        // int[] dp2 = new int[arr.length];
        // Arrays.fill(dp, 1);
        // Arrays.fill(dp2, 1);
        // for (int i = 1; i < arr.length; i++) {
        //     for (int j = 0; j < i; j++) {
        //         if (arr[i] > arr[j] && 1 + dp[j] > dp[i]) {
        //             dp[i] = 1 + dp[j];
        //         }
        //     }
        // }
        // for (int i = n - 2; i >= 0; i--) {
        //     for (int j = n - 1; j > i; j--) {
        //         if (arr[i] > arr[j] && 1 + dp2[j] > dp2[i]) {
        //             dp2[i] = 1 + dp2[j];
        //         }
        //     }
        // }
        // for (int i = 1; i < n - 1; i++) {
        //     if (dp[i] == 1 && dp2[i] == 1)
        //         return false;
        // }
        // return true;
        int j = -1;
        for(int i = 1; i < n ; i++){
            if(arr[i-1]>=arr[i]){
                j = i-1;
                break;
            }
        }
        if(j<=0 || j >=n-1) return false;
        for(int k = j+1 ; k < n ; k++){
            if(arr[k] >= arr[k-1]) return false;
        }
        return true;
    }
}