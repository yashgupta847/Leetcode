class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        f(ans, k, n, new ArrayList<>(), 0);
        return ans;
    }

    public void f(List<List<Integer>> ans, int k, int n, List<Integer> demo, int idx) {
        if (demo.size() == k) {
            if (n == 0) {
                ans.add(new ArrayList<>(demo));
                return;
            }
            return;
        }
        for (int i = idx + 1; i <= 9; i++) {
            demo.add(i);
            f(ans, k, n - i, demo, i);
            demo.remove(demo.size() - 1);
            // f(ans, k, n, demo, i);
        }

    }
}