class Solution {
    public void f(List<List<Integer>> ans, int idx, int[] nums, List<Integer> demo , boolean[] used) {
        // if(idx == nums.length) return;
        if (demo.size() == nums.length) {
            ans.add(new ArrayList<>(demo));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                demo.add(nums[i]);
                f(ans, idx, nums, demo, used);
                used[i] = false;
                demo.remove(demo.size() - 1);
            }
        }

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        f(ans, 0, nums, new ArrayList<>() , used);
        return ans;
    }
}