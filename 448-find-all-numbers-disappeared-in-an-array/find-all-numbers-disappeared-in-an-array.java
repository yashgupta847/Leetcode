class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[Math.abs(nums[i])-1] < 0) continue;
            nums[Math.abs(nums[i])-1] = nums[Math.abs(nums[i])-1]*-1;
        }
        for(int i = 0 ;i < nums.length ; i++){
            if(nums[i] > 0) {
                ans.add(i+1);
            }
        }
        return ans;
    }
}