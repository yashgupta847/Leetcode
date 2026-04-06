class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int ans1 = 0;
        int res1 = 0;
        int ans2 = 0;
        int res2 = 0;
        for (int n : nums) {
            if (n == ans1) {
                res1++;
            } else if (n == ans2) {
                res2++;
            } else if (res1 == 0) {
                ans1 = n;
                res1 = 1;
            } else if (res2 == 0) {
                ans2 = n;
                res2 = 1;
            } else {
                res1--;
                res2--;
            }
        }
        res1 = 0;
        res2 = 0;

        for (int n : nums) {
            if (n == ans1)
                res1++;
            else if (n == ans2)
                res2++;
        }

        List<Integer> result = new ArrayList<>();
        if (res1 > nums.length / 3)
            result.add(ans1);
        if (res2 > nums.length / 3)
            result.add(ans2);

        return result;
    }
}