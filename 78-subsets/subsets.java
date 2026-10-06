class Solution {
    public void f(HashSet<List<Integer>> ans, List<Integer> demo, int idx, int[] nums) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(demo));
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            demo.add(nums[i]);
            f(ans, demo, i + 1, nums);
            demo.remove(demo.size() - 1);
            f(ans, demo, i + 1, nums);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        HashSet<List<Integer>> ans = new HashSet<>();
        f(ans , new ArrayList<>() , 0 , nums);
        Iterator<List<Integer>> it = ans.iterator();
        List<List<Integer>> real = new ArrayList<>();
        while (it.hasNext()) {
            real.add(new ArrayList<>(it.next()));
            it.remove();
        }
        return real;
    }
}