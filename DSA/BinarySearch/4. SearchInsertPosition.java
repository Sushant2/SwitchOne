//program to search for the index of the target value in the array if it were inserted in the array, if it exists return its index

//using LOWER BOUND APPROACH

class Solution {
    public int searchInsert(int[] nums, int target) {
        //with help of lower bound
        //as we want the smallest index of ele >= target
        int low = 0;
        int high = nums.length-1;
        int possAns = nums.length;
        
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] >= target){
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
