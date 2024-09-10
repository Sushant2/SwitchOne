//Program to find maxSum of a subarray & from the subarray the sum would be of first & 2nd smallest element

//GFG - Maximum Score from Subarray Minimums
//Brute Force

class Solution {
    // Function to find pair with maximum sum
    public int pairWithMaxSum(List<Integer> arr) {
        // Your code goes here
        int n = arr.size();
        //Brute Force
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0;i<n-1;i++){
            int sum = 0;
            int smallOne = arr.get(i);
            int smallTwo = arr.get(i+1);
            for(int j = i+1;j<n;j++){
                if(arr.get(j) <= smallOne){
                    smallTwo = smallOne;
                    smallOne = arr.get(j);
                }
                else if(arr.get(j) <= smallTwo)
                    smallTwo = arr.get(j);
                maxSum = Math.max(maxSum, (smallOne + smallTwo));
            }
        }
        return maxSum;
    }
}

//Time Compl - O(n^2)
//Space Compl - O(1)

//Better 
//after observation we found out that the max sum would be of 2 consecute elements only
//so a pair would result into maxSum, that means we can apply SLIDING WINDOW TECHNIQUE

class Solution {
    // Function to find pair with maximum sum
    public int pairWithMaxSum(List<Integer> arr) {
        // Your code goes here
        int n = arr.size();
        //Better Force
        int maxSum = Integer.MIN_VALUE;
        int k = 2; //size of window
        int sum = arr.get(0) + arr.get(1); //initial window sum
        maxSum = Math.max(maxSum, sum);
        for(int i = 2;i<n;i++){
            sum -= arr.get(i-k);
            sum += arr.get(i);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}

//Time Compl - O(n)
//Space Compl - O(1)