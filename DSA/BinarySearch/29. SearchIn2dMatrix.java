//write a program to find x in 2d matrix
//each row is in increasing order
//first element of next row if always greater than last element of its previous row

//Brute Force
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //brute force
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(matrix[i][j] == target)
                    return true;
            }
        }
        return false;
    }
}
//time compl - O(m*n)
//space compl- O(1)

//Better Approach
//no need of iterating every row
//we just check if our target lies in that row, if yes, then only do BS for that row

class Solution {
    public boolean searchTarget(int[] arr, int n, int x){
        int low = 0, high = n-1;
        while(low <= high){
            int mid = (low+high) >>1;
            if(arr[mid] == x){
                return true;
            }else if(arr[mid] < x){
                //goto right
                low = mid+1;
            }else{
                //goto left
                high = mid-1;
            }
        }

        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i = 0;i<m;i++){
            if(matrix[i][0] <= target && target <= matrix[i][n-1])
                return searchTarget(matrix[i], n, target);;
        }
        return false;
    }
}

//time compl - O(m + logn(n))
//space compl - O(1)

//Optimised approach
//we'll try to flatten the 2d matrix into 1d array hypothetically
//& try to do binary search on that
//now we need to convert mid into row, col cordinates
//row = mid/(arr[0].length)
//col = mid%(arr[0].length)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = (m*n)-1;
        while(low <= high){
            int mid = (low + high) >> 1;
            //get row & col from mid
            //row = mid/n
            //col = mid%n
            int row = mid/n;
            int col = mid%n;
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] < target){
                //goto right
                low = mid+1;
            }else{
                //goto left
                high = mid-1;
            }
        }
        return false;
    }
}

//time compl - O(log(m*n))
//space compl - O(1)
