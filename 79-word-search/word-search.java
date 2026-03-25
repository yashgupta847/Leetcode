class Solution {
    public boolean f(char[][] board, String word, int i, int j, int p) {
        if (p == word.length())
            return true;

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return false;

        if (board[i][j] != word.charAt(p))
            return false;

        char temp = board[i][j];
        board[i][j] = '#';
        boolean found = f(board, word, i - 1, j, p + 1) ||
                f(board, word, i + 1, j, p + 1) ||
                f(board, word, i, j - 1, p + 1) ||
                f(board, word, i, j + 1, p + 1);
        board[i][j] = temp; 
        return found;
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (f(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }
}