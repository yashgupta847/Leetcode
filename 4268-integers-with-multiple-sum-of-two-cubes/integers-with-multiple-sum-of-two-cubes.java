class Solution {
    public List<Integer> findGoodIntegers(int n) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> hs = new HashMap<>();
        int limit = (int) Math.cbrt(n);
        for (int i = 1; i <= limit; i++) {
            for (int j = i; j <= limit; j++) {
                int x = i * i * i + j * j * j;
                if (x > n)
                    break;
                hs.put(x, hs.getOrDefault(x, 0) + 1);
            }
        }
        for (int key : hs.keySet()) {
            if (hs.get(key) >= 2) {
                ans.add(key);
            }
        }

        Collections.sort(ans);
        return ans;
    }
}