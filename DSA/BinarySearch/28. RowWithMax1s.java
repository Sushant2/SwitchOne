//write a program to find the row index from 2d array containing only 0 & 1
//each row is in increasing order
//return row index having maximum no of 1s

//Brute Force

class Solution {
    public int rowWithMax1s(int arr[][]) {
        // code here
        int m = arr.length;
        int n = arr[0].length;
        int maxOnes = -1;
        int rowIdx = -1;
        
        for(int i = 0;i<m;i++){
            int currOnes = 0;
            for(int j = 0;j<n;j++){
                if(arr[i][j] == 1){
                    currOnes++;
                }
            }
            if(maxOnes < currOnes){
                maxOnes = currOnes;
                rowIdx = i;
            }
        }
        return rowIdx;
    }
}

//time compl - O(n^2)
//space compl - O(1)


//for optimisation
//using binary search
//approach - 
//[[0, 0, 0]]
//[[0, 1, 1]]
//[[1, 1, 1]]

//to find the total cnt of 1s is equal to getting the sum of row
//so to get the sum, we can find out where the first 1 is?
//so countOnes = colSize - firstOccurenceIdxOf1

class Solution {
    
    public int findCurrOnes(int[] arr, int n){
        int low = 0, high = n-1;
        int idx = n;
        while(low <= high){
            int mid = (low + high) >> 1;
            if(arr[mid] == 1){
                //goto left
                high = mid-1;
                idx = mid;
            }else{
                //goto right
                low = mid+1;
            }
        }
        return idx;
    }
    
    public int rowWithMax1s(int arr[][]) {
        // code here
        int m = arr.length;
        int n = arr[0].length;
        int maxOnes = 0;
        int rowIdx = -1;
        
        for(int i = 0;i<m;i++){
            int currOnes = n - findCurrOnes(arr[i], n);
            if(maxOnes < currOnes){
                maxOnes = currOnes;
                rowIdx = i;
            }
        }
        return rowIdx;
    }
}

//time compl - O(m*(logn))
//spae compl - O(1)
