class Solution {
    List<String> ans = new ArrayList<>();

    public boolean calculate(StringBuilder st, int target) {
        String s = st.toString();
        long result = 0;
        long last = 0;
        long num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {
                if (sign == '+') {
                    result += last;
                    last = num;
                } else if (sign == '-') {
                    result += last;
                    last = -num;
                } else if (sign == '*') {
                    last = last * num;
                }

                sign = ch;
                num = 0;
            }
        }
        result += last;
        return result == target;
    }
    public void f(String num, int target, int idx, StringBuilder st) {
        if (idx == num.length()) {
            if (calculate(st, target)) {
                ans.add(st.toString());
            }
            return;
        }
        for (int i = idx; i < num.length(); i++) {
            if (i > idx && num.charAt(idx) == '0')
                break;
            String part = num.substring(idx, i + 1);
            if (idx == 0) {
                st.append(part);
                f(num, target, i + 1, st);
                st.delete(st.length() - part.length(), st.length());
            } else {
                st.append('+').append(part);
                f(num, target, i + 1, st);
                st.delete(st.length() - part.length() - 1, st.length());
                st.append('-').append(part);
                f(num, target, i + 1, st);
                st.delete(st.length() - part.length() - 1, st.length());
                st.append('*').append(part);
                f(num, target, i + 1, st);
                st.delete(st.length() - part.length() - 1, st.length());
            }
        }
    }

    public List<String> addOperators(String num, int target) {

        f(num, target, 0, new StringBuilder());
        return ans;
    }
}