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

//time compl - O(m*n)
//space compl - O(1)

//Optimised
//as if we traverse the matrix, it'll be m*n, so we need to skip elements to reduce time complexity by searching
//so we'll go with binary search
//we'll consider the first row & apply binary search
//low = 0, high = mat[0].length-1
//for mid col, we'll find the max element from the col
//by this we would've already checked the top & bootm case
//so after we get the max, we just need to check it with left or right
//by this we, can move in one directions in order to find peak & by omitting the other half

class Solution {

    public int findMax(int[][] mat, int mid, int m, int n){
        int row = -1, max = -1;
        for(int i = 0;i<m;i++){
            if(mat[i][mid] > max){
                max = mat[i][mid];
                row = i;
            }
        }
        return row;
    }

    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int low = 0, high = n-1;

        while(low <= high){
            int midIdx = (low + high) >> 1; //we'll be column
            int row = findMax(mat, midIdx, m, n);
            //now we're at mat[row][midIdx]
            //left ele
            int left = (midIdx-1 >= 0) ? mat[row][midIdx-1] : -1;
            //right ele
            int right = (midIdx+1 < n) ? mat[row][midIdx+1] : -1;

            if(mat[row][midIdx] > left && mat[row][midIdx] > right){
                return new int[]{row, midIdx};
            }else if(mat[row][midIdx] < left){
                //peak will be on left - so omit right
                high = midIdx - 1;
            }else{
                low = midIdx+1;
            }
        }
        
        return new int[]{-1, -1};  // No peak found (shouldn't happen)
    }
}

//time compl - O(m*logn)
//space compl - O(1)