//program to print a matrix in spiral format

//Appaoch
//follow your thought process
//take 4 pointers for toprow, bottomrow, leftcol, right col

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> res = new ArrayList<>();

        //4 pointers
        //for toprow, bottomrow, leftcol, rightcol
        int top = 0, bottom = m-1, left = 0, right = n-1; 
        while(top <= bottom && left <= right){
            //first row
            for(int i = left;i<=right;i++){
                res.add(matrix[top][i]);
            }
            top++;
            //last col
            for(int i = top;i<=bottom;i++){
                res.add(matrix[i][right]);
            }
            right--;
            //last row
            if(top <= bottom){
                for(int i = right;i>=left;i--){
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }
            //first col
            if(left <= right){
                for(int i = bottom;i>=top;i--){
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }
}

//Time Compl - O(m*n)
//Space Compl - O(n) - resultant list