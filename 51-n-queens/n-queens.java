class Solution {
    public boolean canPut(char[][] board, List<List<String>> ans, int idx, int p, int n) {
        for (int i = 0; i < idx; i++) {
            if (board[i][p] == 'Q')
                return false;
        }
        for (int i = idx - 1, j = p - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }
        for (int i = idx - 1, j = p + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }
        return true;
    }

    public void f(char[][] board, List<List<String>> ans, int idx, int n) {
        if (idx == n) {
            List<String> demo = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder st = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    st.append(board[i][j]);
                }
                demo.add(st.toString());
            }
            ans.add(new ArrayList<>(demo));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (canPut(board, ans, idx, i, n)) {
                board[idx][i] = 'Q';
                f(board, ans, idx + 1, n);
                board[idx][i] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        f(board, ans, 0, n);
        return ans;
    }
}