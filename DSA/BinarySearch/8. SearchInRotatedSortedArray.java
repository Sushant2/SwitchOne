//program to find the index of an ele if it is present in the rotated sorted array

//approach - try to identify which half is sorted & check in that half if ele is present

class Solution {
    public int search(int[] nums, int k) {
        int n = nums.length;
        int low = 0, high = n-1;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] == k){
                return mid;
            }//left half is sorted
            else if(nums[low] <= nums[mid]){
                //check if k lies in left half
                if(k >= nums[low] && k <= nums[mid]){
                    high = mid-1;
                }else
                    low = mid+1;
            }//right half is sorted
            else{
                //check if k lies in right half
                if(k >= nums[mid] && k <= nums[high]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}


//time compl - O(logn)
//space compl - O(1)