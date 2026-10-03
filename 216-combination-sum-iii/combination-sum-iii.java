class Solution {
    public void f(HashSet<List<Integer>> ans, List<Integer> demo, int k, int n, int idx) {
        if (demo.size() == k) {
            if (n == 0)
                ans.add(new ArrayList<>(demo));
            return;
        }
        for (int i = idx; i <= 9; i++) {
            demo.add(i);
            f(ans, demo, k, n - i, i + 1);
            demo.remove(demo.size() - 1);
            f(ans, demo, k, n, i + 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        HashSet<List<Integer>> ans = new HashSet<>();
        f(ans, new ArrayList<>(), k, n, 1);
        List<List<Integer>> real = new ArrayList<>();
        Iterator<List<Integer>> it = ans.iterator();
        while(it.hasNext()){
            real.add(new ArrayList<>(it.next()));
            it.remove();
        }
        return real;
    }
}