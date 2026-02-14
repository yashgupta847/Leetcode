class Solution {
    public boolean f(String s, String p, int i, int j) {
        if (i < 0 && j < 0)
            return true;
        if (j < 0)
            return false;
        if (i < 0) {
            //for (int l = 0; l <= j; l++) {
            if (p.charAt(j) == '*')
                return f(s, p, i, j - 2);
            //}
            return false;
        }
        if(p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)) return f(s , p , i-1 , j-1);
        if (p.charAt(j) == '*') {
            boolean skip = f(s, p, i, j - 2);
            boolean take = false;

            if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i))
                take = f(s, p, i - 1, j);

            return skip || take;
        }

        return false;

    }

    public boolean isMatch(String s, String p) {
       // boolean
        return f(s, p, s.length() - 1, p.length() - 1);
    }
}