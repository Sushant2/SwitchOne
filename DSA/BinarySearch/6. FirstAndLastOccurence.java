//write a program to find first & last occurence of ele

//linear approach - brute force
//time compl - O(n)
//space compl - O(1)
public int[] searchRange(int[] nums, int target) {
    int n  = nums.length;
    int firstPos = -1;
    int lastPos = -1;
    for(int i = 0;i<=n-1;i++){
        if(nums[i] == target){
            if(firstPos == -1)
                firstPos = i;
            lastPos = i;
        }
    }
    return new int[]{firstPos, lastPos};
}


//using lower bound & upper bound
//time compl - O(2(logn))
//space compl - O(1)

class Solution {
    public static int lowerBound(int []arr, int n, int k) {
        int low = 0;
        int high = n-1;
        
        int possAns = n;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] >= k){
                possAns = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return possAns;
    }
    public static int upperBound(int []arr, int n, int k) {
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
        return possAns-1;
    }
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if(n==0)
            return new int[]{-1, -1};
        int lb = lowerBound(nums, n, target);
        if(lb == n || (nums[lb] != target))
            return new int[]{-1,-1};
        return new int[]{lb, upperBound(nums, n, target)};
    }
}