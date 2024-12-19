//find minimum ele in rotated sorted array

//using binary search

class Solution {
    public int findMin(int[] nums) {
        int mini = Integer.MAX_VALUE;
        int n = nums.length;
        int low = 0;
        int high = n-1;
        //edge case
        if(n==1) return nums[0];
        while(low <= high){
            int mid = (low+high)/2;
            //if serarch space is already sorted, then nums[low] is ans
            if(nums[low] <= nums[high]){
                mini = Math.min(mini, nums[low]);
                break;
            } 
            //if nums[i] > nums[i+1] --> nums[i+1] is ans
            if(low < high && nums[mid] > nums[mid+1])
                return nums[mid+1];
            //if left half is sorted
            if(nums[low] <= nums[mid]){
                mini = Math.min(mini, nums[low]);
                //goto right
                low = mid+1;
            }
            //else right half is sorted
            else{
                mini = Math.min(mini, nums[mid]);
                //goto left
                high = mid-1;
            }
        }
        return mini;
    }
}


//time compl - O(logn)
//space compl - O(1)