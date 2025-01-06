//writw a program to find sqrt of integer n
//If n is not a perfect square, then return the floor value. Floor value of any number is the greatest Integer which is less than or equal to that number


//if you find a range of answers and there may be certain answers and not answers after a point, then we can apply binary search

//Binary Search solution
class Solution {
    int floorSqrt(int n) {
        // Your code here
        if(n==1)
            return 1;
        int low = 1, high = n/2;
        int ans = -1;
        while(low <= high){
            long mid = low + (high-low)/2;
            if(mid <= (long)n/mid){
                ans = (int)mid;
                low = (int)mid+1;
            }else{
                high = (int)mid-1;
            }
        }
        return ans;
    }
}

//time compl - O(logn)
//space compl - O(1)