class Solution {
    public int sumFourDivisors(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (find(nums[i]) == 4) {
                ans += sum(nums[i]);
            }
        }
        return ans;
    }

    public int find(int j) {
        int ans = 0;
        for (int i = 1; i * i <= j; i++) {
            if (j % i == 0) {
                if (i == j / i) {
                    ans++; 
                } else {
                    ans += 2;
                }
            }
            if(ans > 4) return 0;
        }
        return ans;
    }

    public int sum(int j) {
        int ans = 0;
        for (int i = 1; i <= j; i++) {
            if (j % i == 0) {
                ans += i;
            }
        }
        return ans;
    }
}