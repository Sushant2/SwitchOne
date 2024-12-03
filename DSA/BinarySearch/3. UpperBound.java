//program to find lower bound of given ele

//lower bound - smallest index where arr[idex] > k

//Brute force - linear search
//time compl - O(n)
//space compl - O(1)


//Binary Search - optimised

public class Solution {
    public static int lowerBound(int []arr, int n, int k) {
        int low = 0;
        int high = n-1;
        
        int possAns = n;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] > k){
                possAns = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return possAns;
    }
}

//time compl - O(logn)
//space compl - O(1)
