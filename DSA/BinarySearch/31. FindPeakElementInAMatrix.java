//Program to find peak in a matrix


//Brute force
class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        // Single element case
        if (m == 1 && n == 1) 
            return new int[]{0, 0};

        // Single row case
        if (m == 1) {
            for (int j = 0; j < n; j++) {
                //if first comparison returns true eg., j == 0 (in OR case), it does not checks the rest of the comparison till &&
                if ((j == 0 || mat[0][j] > mat[0][j - 1]) &&
                    (j == n - 1 || mat[0][j] > mat[0][j + 1])) {
                    return new int[]{0, j};
                }
            }
        }

        // Single column case
        if (n == 1) {
            for (int i = 0; i < m; i++) {
                if ((i == 0 || mat[i][0] > mat[i - 1][0]) &&
                    (i == m - 1 || mat[i][0] > mat[i + 1][0])) {
                    return new int[]{i, 0};
                }
            }
        }

        // General case (2D matrix)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || mat[i][j] > mat[i - 1][j]) &&
                    (i == m - 1 || mat[i][j] > mat[i + 1][j]) &&
                    (j == 0 || mat[i][j] > mat[i][j - 1]) &&
                    (j == n - 1 || mat[i][j] > mat[i][j + 1])) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};  // No peak found (shouldn't happen)
    }
}
