//Program to find subarray with sum K
//only 0 & +v numbers

//Brute Force - Generate allsubarrays
class Solution {
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr(int arr[], int n, int k) {
        
        int maxLen = 0;
        int sum = 0;
        for(int i = 0;i<n;i++){
            sum = 0;
            for(int j = i;j<n;j++){
                sum += arr[j];
                if(sum == k){
                    maxLen = Math.max(maxLen, (j-i+1));
                }
                if(sum > k)
                    break;
            }
        }
        return maxLen;
    }
}

//Time Compl - O(n^2)
//Space Compl - O(1)


//Better - Using hash that stores prefixSum till that index
class Solution {
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr(int arr[], int n, int k) {
       
       int preSum = 0;
       int maxLen = 0;
       HashMap<Integer, Integer> map = new HashMap<>();
       
       for(int i = 0;i<n;i++){
           preSum += arr[i];
           if(preSum == k)
                maxLen = Math.max(maxLen, (i+1));
            int rem = preSum - k; //that we have to find in map
            if(map.containsKey(rem)){
                int len = i - map.get(rem);
                maxLen = Math.max(maxLen, len);
            }
            //insert in map only for the first time - to handle that zero element case
            if(!map.containsKey(preSum))
                map.put(preSum, i);
       }
       return maxLen;
    }
}


//Time Compl - O(nlogn) or ~o(n)
//Space Compl - O(n)


//Optimised - using 2 pointers & greedy
class Solution {
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr(int arr[], int n, int k) {
        
        int i = 0;
        int j = 0;
        int sum = arr[0];
        int maxLen = 0;
        while(j<n){
            //i<=j till there is a subarray
            while(i<=j && sum > k){
                sum -= arr[i];
                i++;
            }
            if(sum == k)
                maxLen = Math.max(maxLen, (j-i+1));
            j++;
            if(j<n)
                sum += arr[j];
        }
        return maxLen;
    }
}


//Time Compl - O(2n)
//Space Compl - O(1)