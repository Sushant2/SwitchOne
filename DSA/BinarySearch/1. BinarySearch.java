//program to return index if target present in sorted array else return -1

//Iterative approach
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


class Solution {
    public int search(int[] nums, int target) {
        return binarySearchRec(nums, 0, nums.length-1, target);
    }
    public int binarySearchRec(int[] arr, int low, int high, int x){
        if(low > high)
            return -1;
        int mid = (low + (high-low)/2);
        if(arr[mid] == x)
            return mid;
        else if(arr[mid] < x)
            return binarySearchRec(arr, mid+1, high, x);
        else
            return binarySearchRec(arr, low, mid-1, x);
    }
}


//time compl - O(logn)
//space compl - O(1)
