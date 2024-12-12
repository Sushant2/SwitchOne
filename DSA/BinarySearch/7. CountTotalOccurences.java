//find the number of occurrences of target in arr
//same logic as of first and last occurence

class Solution {
    public int findFirst(int[] arr, int k){
        int first = -1;
        int low = 0, high = arr.length-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] == k){
                first = mid;
                high = mid-1;
            }else if(arr[mid] > k)
                high = mid-1;
            else
                low = mid+1;
        }
        return first;
    }
    public int findLast(int[] arr, int k){
        int last = -1;
        int low = 0, high = arr.length-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] == k){
                last = mid;
                low = mid+1;
            }else if(arr[mid] > k)
                high = mid-1;
            else
                low = mid+1;
        }
        return last;
    } 
    int countFreq(int[] arr, int target) {
        // code here
        
            
        int first = findFirst(arr, target);
        int last = findLast(arr, target);
        if(first == -1)
            return 0;
        else
            return last-first+1;
    }
}

//time compl - O(2logn)
//space compl - O(1)