//problem is to = split the arrray into k subarray(comtagious) such that that largest subarray sum is minimized

//this problem is exaclty same as BOOK ALLOCATION PROBLEM AND CAPACITY TO SHIP PACKAGES

//Brute Force - linear approach
class Solution {
    public boolean checkPossible(int[] arr, int sum, int k){
        int currK = 1, currSum = 0;
        for(int i = 0;i<arr.length;i++){
            if(currSum + arr[i] <= sum){
                currSum += arr[i];
            }else{
                currSum = arr[i];
                currK++;
            }
            if(currK > k)
                return false;
        }
        return true;
    }
    public int splitArray(int[] nums, int k) {
        int low = Integer.MIN_VALUE, high = 0;
        for(int e : nums){
            low = Math.max(low, e);
            high += e;
        }
        //linear search
        for(int sum = low;sum<=high;sum++){
            if(checkPossible(nums, sum, k))
                return sum;
        }
        return low;
    }
}
//time compl - O((sumarr-maxarr)*n)
//space compl - O(1)


//Binary Search
class Solution {
    public boolean checkPossible(int[] arr, int sum, int k){
        int currK = 1, currSum = 0;
        for(int i = 0;i<arr.length;i++){
            if(currSum + arr[i] <= sum){
                currSum += arr[i];
            }else{
                currSum = arr[i];
                currK++;
            }
            if(currK > k)
                return false;
        }
        return true;
    }
    public int splitArray(int[] nums, int k) {
        int low = Integer.MIN_VALUE, high = 0;
        for(int e : nums){
            low = Math.max(low, e);
            high += e;
        }
        //linear search
        while(low <= high){
            int mid = low + (high-low)/2;
            if(checkPossible(nums, mid, k)){
                //goto left - as we want minimum
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}
//time compl - O(logn(sumarr-maxarr)*n)
//space compl - O(1)