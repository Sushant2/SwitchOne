//find how many times an array is rotated


class Solution {
    public int findKRotation(List<Integer> nums) {
        // Code here
        int mini = Integer.MAX_VALUE;
        int n = nums.size();
        int low = 0, high = n-1;
        int idx = -1;
        //edge case
        if(n==1) return 0;
        while(low <= high){
            int mid = (low+high)/2;
            //if serarch space is already sorted, then nums.get(low) is ans
            if(nums.get(low) <= nums.get(high)){
                if(nums.get(low) < mini){
                    mini = nums.get(low);
                    idx = low;
                }
                break;
            } 
            //if nums[i] > nums[i+1] --> nums[i+1] is ans
            if(low < high && nums.get(mid) > nums.get(mid+1))
                return mid+1;
            //if left half is sorted
            if(nums.get(low) <= nums.get(mid)){
                if(nums.get(low) < mini){
                    mini = nums.get(low);
                    idx = low;
                }
                //goto right
                low = mid+1;
            }
            //else right half is sorted
            else{
                if(nums.get(mid) < mini){
                    mini = nums.get(mid);
                    idx = mid;
                }
                //goto left
                high = mid-1;
            }
        }
        return idx;
    }
}



//time compl - O(logn)
//space compl - O(1)