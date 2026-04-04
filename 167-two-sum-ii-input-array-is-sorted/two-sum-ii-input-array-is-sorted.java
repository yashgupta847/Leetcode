class Solution {
    public int[] twoSum(int[] nums, int t) {
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            if(nums[l]+nums[r] == t){
                return new int[]{l+1 , r+1};
            } else if(nums[l]+nums[r] < t){
                l++;
            } else r--;
        }
        return new int[]{-1,-1};
    }
}