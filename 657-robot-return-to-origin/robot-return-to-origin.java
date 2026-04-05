class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'L') {
                x++;
            } else if (moves.charAt(i) == 'R') {
                x--;
            } else if (moves.charAt(i) == 'U') {
                y++;
            } else
                y--;
        }
        if (x == 0 && y == 0)
            return true;
        return false;
    }
}