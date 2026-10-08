class Solution {
    public String removeOuterParentheses(String s) {
        int open = 0;
        int close = 0;
        HashMap<Integer, Character> hs = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hs.put(i, s.charAt(i));
        }
        int idx = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (open == 0)
                    idx = i;
                open++;
            } else {
                if (open == 1) {
                    hs.remove(idx);
                    hs.remove(i);
                }
                open--;
            }
        }
        StringBuilder st = new StringBuilder();
        for (char value : hs.values()) {
            st.append(value);
        }
        return st.toString();
    }
}