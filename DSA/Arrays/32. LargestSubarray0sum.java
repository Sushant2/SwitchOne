//program to find a largest subarray with 0 sum

//Brute force/naive
// consider all possible subarrays of the given array and check for the subarrays that sum to zero.
class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        int maxSize = 0;
        
        for(int i = 0;i<n;i++){
            int currSum = 0;
            for (int j = i; j < n; j++) {
                currSum += arr[j];
            
                if (currSum == 0) 
                    maxSize = Math.max(maxSize, j - i + 1);
                }
            }
        return maxSize;
    }
}

//time compl - O(n^2)
//space compl - O(1)


//Optimal Solution
//using hashing/prefix sum
// [1, 2, 3, 4, 5, 6, 7, 8]
// [---s---]
//          [----0----]
//[---------s---------]
//we'll keep adding in sum & check if it is equals to 0 or if the sum exists previously
class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        int maxLen = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            sum += arr[i];
            if(sum == 0)
                maxLen = i+1;
            else if(map.containsKey(sum))
                maxLen = Math.max(maxLen, i-map.get(sum));
            else
                map.put(sum, i);
        }
        return maxLen;
    }
}

//time compl - O(n)
//space compl - O(n)