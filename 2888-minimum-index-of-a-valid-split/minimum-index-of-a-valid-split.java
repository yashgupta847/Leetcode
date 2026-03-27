class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();

        HashMap<Integer, Integer> hs = new HashMap<>();
        for (int num : nums) {
            hs.put(num, hs.getOrDefault(num, 0) + 1);
        }
        int dominant = -1;
        for (int key : hs.keySet()) {
            if (hs.get(key) > n / 2) {
                dominant = key;
                break;
            }
        }

        int cnt = 0;

        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) == dominant)
                cnt++;

            if (cnt > (i + 1) / 2 &&
                    (hs.get(dominant) - cnt) > (n - i - 1) / 2) {
                return i;
            }
        }

        return -1;
    }
}