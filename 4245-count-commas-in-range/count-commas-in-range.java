class Solution {
    public int countCommas(int n) {

        // String s = Integer.toString(n);
        // if (s.length() <= 3)
        //     return 0;
        // // return s.length() / 4;
        int cnt = 0;
        for (int i = 1000; i <= n; i++) {
            String s = Integer.toString(i);
            if (s.length() % 3 == 0) {
                cnt += s.length() / 3 - 1;
            } else
                cnt += s.length() / 3;
        }
        return cnt;
    }
}