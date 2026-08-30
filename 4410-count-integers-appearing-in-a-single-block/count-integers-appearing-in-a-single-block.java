class Solution {
    public int countSpecialIntegers(int[] nums) {
        int ans = 0;
        int[] freq = new int[101];
        for(int i = 0 ; i < nums.length ; i++){
            freq[nums[i]]++;
        }
        if(nums.length == 1) return 1;
        for(int i = 0 ; i < nums.length ; i++){
            int j = i;
            while(i+1 < nums.length && nums[i] == nums[i+1]){
                i++;
                freq[nums[i]]--;
            }
            if(j != i && freq[nums[i]] == 0) ans++;
            else if(freq[nums[i]] == 1) ans++;
        }
        return ans;
    }
}