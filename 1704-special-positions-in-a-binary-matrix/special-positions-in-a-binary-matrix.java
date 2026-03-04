class Solution {
    public int numSpecial(int[][] mat) {
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    int row = i;
                    int column = j;
                    boolean yes1 = true;
                    boolean yes2 = true;
                    for (int k = 0; k < mat[0].length; k++) {
                        if (k != column && mat[row][k] == 1) {
                            yes1 = false;
                            break;
                        }
                    }
                    for (int k = 0; k < mat.length; k++) {
                        if (k != i && mat[k][column] == 1) {
                            yes2 = false;
                            break;
                        }
                    }
                    if (yes1 && yes2)
                        count++;
                }
            }
        }
        return count;
    }
}