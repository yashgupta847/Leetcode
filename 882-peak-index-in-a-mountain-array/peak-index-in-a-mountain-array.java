class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int ans = 0;
        int ans1 = 0;
        for(int i = 0 ;i< arr.length ;i++){
            if(ans < arr[i]){
                ans = arr[i];
                ans1 = i;
            }
        }
        return ans1;
    }
}