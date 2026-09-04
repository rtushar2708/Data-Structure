class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // transpose the matrix then reverse every row
        for(int i = 0; i < n-1; i++) {
            for(int j = i+1; j < n; j++) {
                swap(matrix, i, j);
            }
        }

        for(int i = 0; i < n; i++) {
            reverse(matrix, 0, n-1, i);
        }
    }

    public void swap(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    public void reverse(int[][] matrix, int start, int end, int i) {
        while(start < end) {
            int temp = matrix[i][start];
            matrix[i][start] = matrix[i][end];
            matrix[i][end] = temp;
            start++;
            end--;
        }
    }
}