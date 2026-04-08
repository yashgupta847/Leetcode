class Solution {
    public void f(List<String> ans, int idx, StringBuilder st, String s, HashSet<String> hs) {
        if (idx == s.length()) {
            ans.add(st.toString().trim());
            return;
        }
        for (int j = idx; j < s.length(); j++) {
            String p = s.substring(idx, j + 1);
            if (hs.contains(p)) {
                int len = st.length();
                // st.append(" ");
                st.append( p );
                st.append(" ");
                f(ans, j + 1, st, s, hs);
                st.setLength(len);
            }
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        HashSet<String> hs = new HashSet<>(wordDict);
        f(ans, 0, new StringBuilder(), s, hs);
        return ans;
    }
}