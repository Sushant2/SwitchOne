//Program to find count of all subarrays whose sum equals K

//Brute Force
class Solution {
    public int subarraySum(int[] nums, int k) {
        //Brute Force
        //Gen all subarrays
        int cnt = 0;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            int sum = 0;
            for(int j = i;j<n;j++){
                sum += nums[j];
                if(sum == k)
                    cnt++;
            }
        }
        return cnt;
    }
}

//Time Compl - O(n^2)
//Space Compl - O(1)

//Better
//Storing prefix sum in hasmap with count of prefix sum
//cos we want to return how many times that presfix sum has in our array

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //initially prefix sum is 0, so add that in map initially
        map.put(0, 1);
        int cnt = 0;
        int preSum = 0;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            preSum += nums[i];
            int rem = preSum - k;
            if(map.containsKey(rem)){
                cnt += map.get(rem);
            }
            int val = map.getOrDefault(preSum, 0);
            map.put(preSum, val+1);
        }
        return cnt;
    }
}

//Time Compl - O(n)
//Space Compl - O(n)