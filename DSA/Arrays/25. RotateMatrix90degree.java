//Program to rotate a matrix 90degree clockwise

//Brute Force
class Solution {
    public void rotate(int[][] matrix) {
        //Brute Force - using extra 2d array
        int n = matrix.length;
        int[][] mat2 = new int[n][n];

        for(int i = n-1;i>=0;i--){
            for(int j = 0;j<n;j++){
                mat2[j][(n-1)-i] = matrix[i][j];
            }
        }

        //replace back ele to given matrix
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                matrix[i][j] = mat2[i][j];
            }
        }
    }
}


//Time Compl - o(n^2)
//Space Compl - O(n^2)






//Better - Transpose -> reverse each row
//On observation we found that first col is in reverse in answer array & so on
class Solution {
    public void reverse(int[][] matrix, int row){
        int left = 0; int right = matrix.length-1;
        while(left <= right){
            int temp = matrix[row][left];
            matrix[row][left] = matrix[row][right];
            matrix[row][right] = temp;
            left++;
            right--;
        }
    }
    public void rotate(int[][] matrix) {
        //Better - Transpose -> reverse each row
        int n = matrix.length;
        for(int i = 0;i<=n-2;i++){
            for(int j = i+1;j<=n-1;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //reverse each row
        for(int i = 0;i<n;i++){
            reverse(matrix, i);
        }
    }
}
//Time Compl - o(n^2)
//Space Compl - O(1)