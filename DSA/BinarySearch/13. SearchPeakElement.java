//find peak element in an array

//brute force
//linear searching

class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        //edge cases
        if(n == 1) return 0;
        if(nums[0] > nums[1]) return 0;
        if(nums[n-1] > nums[n-2]) return n-1;

        for(int i = 1;i<=n-2;i++){
            if(nums[i] > nums[i-1] && nums[i] > nums[i+1])
                return i;
        }
        return -1;
    }
}


//time compl - O(n)
//space compl - O(1)

//optimal approach

//using binary search
//think of elimination of search space

class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        //edge cases
        if(n == 1) return 0;
        if(nums[0] > nums[1]) return 0;
        if(nums[n-1] > nums[n-2]) return n-1;
        
        int low = 1, high = n-2;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1])
                return mid;
            else if(nums[mid] > nums[mid-1]){
                //peak on right
                low = mid+1;
            }
            else if(nums[mid] > nums[mid+1]){
                //peak on left
                high = mid-1;
            }else {
                //peak on both sides
                //eg- [1, 5, 1, 3, 1]
                high = mid-1; //or low = mid+1
            }
        }
        return -1;
    }
}


//OR WE CAN WRITE IT AS SIMPLE AS
//COMBINING LAST 2 CASES

class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        //edge cases
        if(n == 1) return 0;
        if(nums[0] > nums[1]) return 0;
        if(nums[n-1] > nums[n-2]) return n-1;
        
        int low = 1, high = n-2;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1])
                return mid;
            else if(nums[mid] > nums[mid-1]){
                //peak on right
                low = mid+1;
            }
            else {
                high = mid-1; 
            }
        }
        return -1;
    }
}

//time compl - O(logn)
//space compl - O(1)