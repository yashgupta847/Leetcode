class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int n = encodedText.length();
        int columns = n / rows;
        int k = 0;

        char[][] matrix = new char[rows][columns];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = encodedText.charAt(k);
                k++;
            }
        }
        
        StringBuilder s = new StringBuilder();
        // if (last == 0)
        //     last = 1;
        for (int j = 0; j < matrix[0].length; j++) {
            int i = 0;
            int p = j;
            while (i < matrix.length && p < matrix[0].length) {
                s.append(matrix[i][p]);
                i++;
                p++;
            }
        }
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        return s.substring(0, end + 1);
    }
}