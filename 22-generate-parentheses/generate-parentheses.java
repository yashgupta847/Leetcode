class Solution {
    public void f(List<String> ans, StringBuilder st, int open, int close, int n) {
        if (open == close && open == n) {
            ans.add(st.toString());
            return;
        }
        if (open < n) {
            st.append('(');
            // open++;
            f(ans, st, open + 1, close, n);
            st.deleteCharAt(st.length() - 1);
            // open--;
        }
        
        if (open > close) {
            st.append(')');
            // close++;
            f(ans, st, open, close+1, n);
            st.deleteCharAt(st.length() - 1);
            // close--;
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        f(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }
}