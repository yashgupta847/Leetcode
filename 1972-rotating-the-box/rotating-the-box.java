class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int n = boxGrid.length;
        int m = boxGrid[0].length;
        char[][] ans = new char[m][n];
        for (int i = n - 1; i >= 0; i--) {
            int row = n - i - 1;
            int end = m - 1;
            while (end >= 0) {
                int count = 0;
                int start = end;
                while (start >= 0 && boxGrid[i][start] != '*') {
                    if (boxGrid[i][start] == '#')
                        count++;
                    start--;
                }
                if (start >= 0)
                    ans[start][row] = '*';
                for (int k = end; k > start; k--) {
                    if (count > 0) {
                        ans[k][row] = '#';
                        count--;
                    } else {
                        ans[k][row] = '.';
                    }
                }
                end = start - 1;
            }
        }
        return ans;
    }
}