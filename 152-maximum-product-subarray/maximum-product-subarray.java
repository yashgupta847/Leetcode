class Solution {
    public int maxProduct(int[] nums) {
     //   int[] p = Arrays.clone(nums);
       // int max = p.sort()[p.length - 1];
       int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = i; j < nums.length; j++) {
                product *= nums[j];
                if (product > max)
                    max = product;
            }
        }
        return max;
    }
}