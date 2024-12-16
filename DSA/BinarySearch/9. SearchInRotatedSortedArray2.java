//program to find the index of an ele if it is present in the rotated sorted array
//duplicate elements can be there

//approach - try to identify which half is sorted & check in that half if ele is present
//prev sol will not work for this case when : arr[low] = arr[mid] = arr[high], as won't be able to find the sorted half
//so to handle, we'll trim down the search space - by taking benifit of this case as - 
//we know if arr[mid] != target
//then first(arr[low]) & last(arr[high]) will also not be equal to target, so we'll trim down the search space & continue
class Solution {
    public boolean search(int[] nums, int k) {
        int n = nums.length;
        int low = 0, high = n-1;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] == k){
                return true;
            }//left half is sorted
            else if(nums[low] == nums[mid] && nums[mid] == nums[high]){
                low = low+1;
                high = high-1;
                continue;
            }
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
        return false;
    }
}

//time compl - O(n/2) - as in worst case, we need to trim all the elements to get the the target
//space compl - O(1)