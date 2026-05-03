class Solution {
    public boolean rotateString(String s, String goal) {
        if(goal.length() != s.length()) return false;
        String p = s + s;
        return p.contains(goal);
    }
}