class Solution {
    Boolean[][] dp;

    public boolean isValid(StringBuilder s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                st.push('(');
            } else {
                if (st.isEmpty())
                    return false;
                st.pop();
            }
        }

        return st.isEmpty();
    }

    boolean f(StringBuilder s, int idx, int balance) {

        if (balance < 0)
            return false;

        if (idx == s.length())
            return balance == 0;

        if (dp[idx][balance] != null)
            return dp[idx][balance];

        char c = s.charAt(idx);

        if (c == '(') {
            return dp[idx][balance] = f(s, idx + 1, balance + 1);
        }

        if (c == ')') {
            return dp[idx][balance] = f(s, idx + 1, balance - 1);
        }

        if (f(s, idx + 1, balance + 1))
            return dp[idx][balance] = true;

        if (f(s, idx + 1, balance - 1))
            return dp[idx][balance] = true;

        if (f(s, idx + 1, balance))
            return dp[idx][balance] = true;

        return dp[idx][balance] = false;
    }

    public boolean checkValidString(String s) {
        dp = new Boolean[s.length()][s.length()+1];

        return f(new StringBuilder(s), 0 , 0);
    }
}