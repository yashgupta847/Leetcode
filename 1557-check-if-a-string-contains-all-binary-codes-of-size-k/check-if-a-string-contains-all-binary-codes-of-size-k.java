class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i <= s.length() - k; i++) {
            StringBuilder st = new StringBuilder();
            for (int j = i; j < i + k; j++) {
                st.append(s.charAt(j));
            }
            hs.add(st.toString());
        }
        if (hs.size() != Math.pow(2, k))
            return false;
        return true;
    }
}