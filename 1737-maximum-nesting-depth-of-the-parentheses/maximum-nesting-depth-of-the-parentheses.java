class Solution {
    public int maxDepth(String s) {
        int close = 0;
        int ans = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                close++;
            } else if (s.charAt(i) == '(') {
                close--;
            } else
                continue;
            ans = Math.max(ans, close);

        }
        return ans;
    }
}
