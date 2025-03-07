//write a program which returns true if the target present in 2d array
//matrix each row & each column is sorted in ascending order

//Brute force
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(target == matrix[i][j])
                    return true;
            }
        }
        return false;
    }
}

//time compl - O(m*n)
//spac compl - O(1)

//Better 
//apply binary serch on each row

class Solution {
    public boolean checkIfContains(int[] arr, int n, int target){
        int low = 0, high = n-1;
        while(low <= high){
            int mid = (low + high) >> 1;
            if(arr[mid] == target)
                return true;
            else if(arr[mid] < target){
                //goto right
                low = mid+1;
            }else
                high = mid-1;
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        for(int i = 0;i<m;i++){
            boolean isContains = checkIfContains(matrix[i], n, target);
            if(isContains)
                return true;
        }
        return false;
    }
}
//time compl - O(m * log(n))
//space compl - O(1)

//Optimised

//we can think of start traversing the matrix from corners
//but from (0, 0) corner both directions are in inc order - so impossible to search in 1 direction
//similarly from (m-1, n-1) corner, both directions are in decreasing order - impossible to search in 1 direction
//so start either (0, n-1) {in this case - u can traverse top to bottom or right to left}
//for (m-1, 0) {in this case - u can traverse bottom to top or left to right}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        //start from (0, n-1)
        int row = 0, col = n-1;
        while(row < m && col >= 0){
            if(matrix[row][col] == target)
                return true;
            else if(matrix[row][col] < target){
                //goto bottom
                row++;
            }else{
                col--;
            }
        }
        return false;
    }
}

//time compl - O(m+n)
//space compl - O(1)