class Solution {
    public void f(List<List<Integer>> ans, int[] c, int t, int idx, ArrayList<Integer> demo) {
        if (t == 0) {
            ans.add(new ArrayList<>(demo));
            return;
        }
        if (idx == c.length || t < 0)
            return;

        demo.add(c[idx]);
        f(ans, c, t - c[idx], idx + 1, demo);
        demo.remove(demo.size() - 1);
        int i = idx;
        while (i + 1 < c.length && c[idx] == c[i + 1]) {
            i++;
        }
        f(ans, c, t, i + 1, demo);

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        f(ans, candidates, target, 0, new ArrayList<>());
        return ans;
    }
}