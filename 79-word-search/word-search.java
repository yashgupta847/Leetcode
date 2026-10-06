class Solution {

    public boolean f(char[][] board, String word, int i, int j, int[][] dirs, int idx, boolean[][] visited) {

        if (idx == word.length())
            return true;
        // if(board[i][j] == word.charAt(idx)){
        for (int[] dir : dirs) {
            int nx = dir[0] + i;
            int ny = dir[1] + j;
            if (nx >= 0 && ny >= 0 && nx < board.length && ny < board[0].length && board[nx][ny] == word.charAt(idx)
                    && !visited[nx][ny]) {
                visited[nx][ny] = true;
                if (f(board, word, nx, ny, dirs, idx + 1, visited))
                    return true;
                visited[nx][ny] = false;
            }
            // }
        }
        return false;
    }

    public boolean exist(char[][] board, String word) {
        if (board.length * board[0].length < word.length())
            return false;
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean ans = false;
                if (word.charAt(0) == board[i][j]) {
                    visited[i][j] = true;
                    ans = f(board, word, i, j, dirs, 1, visited);
                    visited[i][j] = false;
                }
                if (ans) {
                    return true;
                }
            }
        }
        return false;
    }
}