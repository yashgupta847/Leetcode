class Solution {
    public int[] buildLps(String goal) {
        int[] lps = new int[goal.length()];
        int len = 0;
        int i = 1;
        while (i < lps.length) {
            if (goal.charAt(i) == goal.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i++] = 0;
                }
            }
        }
        return lps;
    }

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length())
            return false;
        int[] lps = buildLps(goal);
        String p = s + s;
        int i = 0, j = 0;
        while (i < p.length()) {
            if (p.charAt(i) == goal.charAt(j)) {
                i++;
                j++;
            }
            if (j == goal.length())
                return true;
            else if (i < p.length() && p.charAt(i) != goal.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }
}