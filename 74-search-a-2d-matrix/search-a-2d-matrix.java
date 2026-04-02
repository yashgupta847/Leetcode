class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // for(int i = 0 ; i < matrix.length*matrix[0].length ; i++){
        int l = 0;
        int r = matrix.length * matrix[0].length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (matrix[mid / matrix[0].length][mid % matrix[0].length] == target)
                return true;
            else if (matrix[mid / matrix[0].length][mid % matrix[0].length] > target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return false;
        // }
    }
}