//program to return index if target present in sorted array else return -1

class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }
}


//time compl - O(logn)
//space compl - O(1)


