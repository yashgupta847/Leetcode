class Solution {
    public List<List<Integer>> findDisappearedNumbers(
            int[] nums, int lower, int higher) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        int current = lower;

        for (int x : nums) {

            if (x < lower || x > higher) {
                continue;
            }

            if (x > current) {
                ans.add(Arrays.asList(current, x - 1));
            }

            current = x + 1;
        }

        if (current <= higher) {
            ans.add(Arrays.asList(current, higher));
        }

        return ans;
    }
}