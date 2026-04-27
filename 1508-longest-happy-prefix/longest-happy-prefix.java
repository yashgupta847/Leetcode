class Solution {
    public String longestPrefix(String s) {
        int[] lps = new int[s.length()];
        lps[0] = 0;
        int len = 0;
        int n = s.length();
        for (int i = 1; i < n;) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return s.substring(0 , lps[s.length()-1]);
    }
}

// Y direct kmp algo se solve ho jaega !! YUHU