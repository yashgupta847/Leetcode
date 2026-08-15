class Solution {
        public int minOperations(String s) {
        int n = s.length(), res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int cur = i;
            for (int j = 0; j < n / 2; j++) {
                int a = s.charAt((i + j) % n);
                int b = s.charAt((i - j - 1 + n) % n);
                int d = Math.abs(a - b);
                cur += Math.min(d, 26 - d);
                if (cur > res) {
                    break;
                }
            }
            res = Math.min(res, cur);
        }
        return res;
    }
}