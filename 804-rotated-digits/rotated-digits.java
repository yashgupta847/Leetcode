class Solution {
    public boolean f(String s) {
        StringBuilder st = new StringBuilder();
        boolean changed = false;
        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i) - '0';

            if (a == 3 || a == 4 || a == 7)
                return false;

            if (a == 2 || a == 5 || a == 6 || a == 9)
                changed = true;
        }
        return changed;
    }

    public int rotatedDigits(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (f(Integer.toString(i)))
                count++;
        }
        return count;
    }
}