//Find the Smallest Divisor Given a Threshold

//exactly same approach as min days to make m bouquets

//Brute force
//linear solution
class Solution {
    public boolean isPossible(int[] arr, int num, int thr){
        int sum = 0;
        for(int ele : arr){
            sum += Math.ceil((float)ele/(float)num);
        }
        return sum <= thr;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        //min num will always be 1, that can divide each number
        int max = Integer.MIN_VALUE;
        for(int ele : nums){
            max = Math.max(max, ele);
        }
        for(int num = 1;num<=max;num++){
            if(isPossible(nums, num, threshold))
                return num;
        }
        return -1;
    }
}

//time compl - O(max*n)
//space compl - O(1)


//Optimised - using binary search
class Solution {
    public boolean isPossible(int[] arr, int num, int thr){
        int sum = 0;
        for(int ele : arr){
            sum += Math.ceil((float)ele/(float)num);
        }
        return sum <= thr;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        //min num will always be 1, that can divide each number
        int max = Integer.MIN_VALUE;
        for(int ele : nums){
            max = Math.max(max, ele);
        }
        int low = 1, high = max;
        while(low <= high){
            int mid = low + (high-low)/2;
        
            if(isPossible(nums, mid, threshold))
                high = mid-1;
            else
                low = mid+1;
        }
        return low;
    }
}

//time compl - O(logmax*n)
//space compl - O(1)