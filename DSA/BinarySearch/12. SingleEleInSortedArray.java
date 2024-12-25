// every element appears exactly twice, except for one element which appears exactly once in sorted array, find single element

//brute force
//using xor

class Solution {
    public int singleNonDuplicate(int[] nums) {
        //using xor
        int xor = 0;
        for(int num : nums){
            xor ^= num;
        }
        return xor;
    }
}

//time compl - O(n)
//space compl - O(1)


//optimised using binary search
//to apply binary search - think to element search space

//The pairs which are on the left of the single element, will have the first element in an even position and the second element at an odd position. All the pairs which are on the right side of the single element will have the first position at an odd position and the second element at an even position. Use this fact to decide whether to go to the left side of the array or the right side.
//If I'm on (even, odd), the element occurs after me, so eliminate everything before me (the left half)
//If I'm on (odd, even), the element occurred before me, so eliminate everything after me (the right half)
        // idx - [0, 1, 2, 3, 4, 5, 6, 7, 8]
        // arr - [1, 1, 2, 3, 3, 4, 4, 8, 8]

class Solution {
    public int singleNonDuplicate(int[] nums) {

        int n = nums.length;
        int low = 0, high = n-1;
        if(n==1) return nums[0];
        if(nums[0] != nums[1])
            return nums[0];
        if(nums[n-1] != nums[n-2])
            return nums[n-1];
        //handled the idx=0 & idx=n-1 conditions separately, thereby trim down the search space to low = 1, high = n-2
        low = 1;
        high = n-2;
        while(low <= high){
            int mid = (low+high) >> 1;
            //if nums[mid] is single ele
            if(nums[mid-1] != nums[mid] && nums[mid+1] != nums[mid])
                return nums[mid];
            else if(((nums[mid-1] == nums[mid]) && mid%2 == 0) || (nums[mid] == nums[mid+1]) && mid%2!=0){
                //(odd, even) -> goto left
                high = mid-1;
            }else{
                //goto right
                low = mid+1;
            }
        }
        return -1;
    }
}