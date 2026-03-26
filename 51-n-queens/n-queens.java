class Solution {
    public boolean canPut(char[][] board, List<List<String>> ans, int idx, int i, int n) {
        for (int j = 0; j < n; j++) {
            if (board[j][i] == 'Q' && j != idx) {
                return false;
            }
            if (board[idx][j] == 'Q' && i != j) {
                return false;
            }
        }
        int r = idx ; int c = i;
        while (c + 1 < n && r + 1 < n) {
            c++;
            r++;
            if (board[r][c] == 'Q')
                return false;

        }
        r = idx; c = i;
        while (c - 1 >= 0 && r - 1 >= 0) {
            c--;
            r--;
            if (board[r][c] == 'Q')
                return false;

        }
        r = idx ; c = i;
        while (r + 1 < n && c - 1 >= 0) {
            r++;
            c--;
            if (board[r][c] == 'Q')
                return false;

        }
        r = idx ; c = i;
        while (r - 1 >= 0 && c + 1 < n) {
            r--;
            c++;
            if (board[r][c] == 'Q')
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