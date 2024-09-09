//program to find the subarray with maximum sum & return sum

//Brute force
class Solution {
    public int maxSubArray(int[] nums) {
        //Brute Force
        int n = nums.length;
        int maxSum = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                int sum = 0;
                //subarray from i to j
                for(int k = i;k<=j;k++){
                    sum += nums[k];
                    if(maxSum < sum)
                        maxSum = sum;
                }
            }
        }
        return maxSum;
    }
}

//Time Compl - O(n^3)
//Space Compl - O(1)

//Better
//Reducing to O(n^2) - no need of 3rd loop, if we're starting from i everytime
class Solution {
    public int maxSubArray(int[] nums) {
        //Better
        int n = nums.length;
        int maxSum = 0;
        for(int i = 0;i<n;i++){
            int sum = 0;
            for(int j = i;j<n;j++){
                sum += nums[j];
                if(maxSum < sum)
                    maxSum = sum;
            }
        }
        return maxSum;
    }
}

//Time Compl - O(n^2)
//Space Compl - O(1)

//Optimised
//KADANE'S ALGORITHM

class Solution {
    public int maxSubArray(int[] nums) {
       int n = nums.length;
       int maxSum = Integer.MIN_VALUE;
       int currSum = 0;
        for(int i = 0;i<n;i++){
            currSum += nums[i];
            //write this maxSum comparsion before making currSum = 0, as there can be a -ve number greater than Integer.MIN_VALUE
            if(maxSum < currSum)
                maxSum = currSum;
            if(currSum < 0)
                currSum = 0;
            
        }
        return maxSum;
    }
}

//Time Compl - O(n)
//Space Compl - O(1)

//#########################Follow Up Question#########################
//Also to print the subarray having maximum sum(there can be multiple so print any)

//if we notice, we know, whenever currSum = 0, there starting a new subarray which can lead to maxSum
//so we can store that point as starting point of subArray & the ending point where we get the maxSum

//so little bit modification in KADANE'S ALGORITHM

class Solution {
    public int maxSubArray(int[] nums) {
       int n = nums.length;
       int maxSum = Integer.MIN_VALUE;
       int currSum = 0;
        int start = 0;
        int subArrayStart = 0;
        int subArrayEnd = 0;
        for(int i = 0;i<n;i++){
            if(currSum == 0)
                start = i;
            currSum += nums[i];
            //write this maxSum comparsion before making currSum = 0, as there can be a -ve number greater than Integer.MIN_VALUE
            if(maxSum < currSum){
                maxSum = currSum;
                subArrayStart = start;
                subArrayEnd = end;
            }
            if(currSum < 0)
                currSum = 0;
        }
        return maxSum;
    }
}