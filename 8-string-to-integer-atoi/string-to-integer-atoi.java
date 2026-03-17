class Solution {
    public String s1 = "";
    public boolean started = false;
    public boolean signTaken = false;

    public void f(String s, int i) {
        if (i == s.length())
            return;
        char ch = s.charAt(i);
        if (!started && s.charAt(i) == ' ') {
            f(s, i + 1);
            return;
        }
        started = true;
        if ((ch == '+' || ch == '-') && !signTaken && s1.length() == 0) {
            s1 += ch;
            signTaken = true;
            f(s, i + 1);
            return;
        }
        if (Character.isDigit(ch)) {
            s1 += ch;
            f(s, i + 1);
            return;
        }
    }

    public int myAtoi(String s) {
        f(s, 0);
        if (s1.equals("") || s1.equals("+") || s1.equals("-"))
            return 0;
        try {
            return Integer.parseInt(s1);
        } catch (Exception e) {
            if (s1.charAt(0) == '-')
                return Integer.MIN_VALUE;
            return Integer.MAX_VALUE;
        }
    }
}