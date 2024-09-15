//Program - Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

//LC - 73

//Brute Force
//using temp matrix
class Solution {
    public void markRow(int[][] arr, int row){
        for(int i = 0;i<arr[0].length;i++)
            arr[row][i] = 0;
    }
    public void markCol(int[][] arr, int col){
        for(int i = 0;i<arr.length;i++)
            arr[i][col] = 0;
    }
    public void copyMat(int[][]arr, int[][] brr, int m, int n){
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                arr[i][j] = brr[i][j];
            }
        }
    }
    public void setZeroes(int[][] matrix) {
        //brute force approach
        // using extra matrix
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] temp = new int[m][n];
        copyMat(temp, matrix, m, n);
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(matrix[i][j] == 0){
                    markRow(temp, i);
                    markCol(temp, j);
                }
            }
        }
        copyMat(matrix, temp, m, n);
    }
}

//Time Compl - O((m*n)*(m+n))
//Space Compl - O(m*n)

//Better
//instead of taking temo whole matrix, we can only take a row array & col array
//that will get marked as 1, if there is any arr[i][j] is 0
class Solution {
    public void setZeroes(int[][] matrix) {
        //Better
        int m = matrix.length;
        int n = matrix[0].length;
        int[] row = new int[m];
        int[] col = new int[n];

        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(matrix[i][j] == 0){
                    //marking
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(row[i] == 1 || col[j] == 1)
                    matrix[i][j] = 0;
            }
        }
    }
}

//Time Compl - O(m*n)
//Space Compl - O(m + n)


//Optimal
//we know iteration in mnatrix takes O(n^2) - so we can't further reduce time compl
//so we'll try to reduce space compl
//instead of taking 2 exteranl array for row & col, we'll use these both array as a part of matrix internally
//so the row array -> 0th row
//so the col array -> 0th col
//but matrix[0][0] is collining in both - which can distort our final matrix
// for 0th index for row & col, we will keep 2 separate variables
//while resulting answer we'll start from end

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // int[] row = matrix[...][0]
        // int[] col = matrix[0][...]
        int col0 = 0;
        int row0 = 0;
        for(int j = 0;j<n;j++){
            if(matrix[0][j] == 0)
                row0 = 1;
        }
        for(int i = 0;i<m;i++){
            if(matrix[i][0] == 0)
                col0 = 1;
        }
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //now start traversing from last ele in matrix - to avoid distortion of matrix

        //from m-1, n-1 -> 1,1
        for(int i = m-1;i>=1;i--){
            for(int j = n-1;j>=1;j--){
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }
        //now 0th row
        if(row0 == 1){
            for(int j = n-1;j>=0;j--)
                matrix[0][j] = 0;
        }
        //now 0th col
        if(col0 == 1){
            for(int i = m-1;i>=0;i--)
                matrix[i][0] = 0;
        }
    }
}