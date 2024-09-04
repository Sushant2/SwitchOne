//Program to 1 - Return YES if there exist two numbers such that their sum is equal to the target. Otherwise, return NO.
//2 - Return indices of the two numbers such that their sum is equal to the target. Otherwise, we will return {-1, -1}.

//Brute Force
//select one & find another one to get target
class Solution {
    public int[] twoSum(int[] nums, int target) {
        //Brute force
        int n = nums.length;
        for(int i = 0;i<n-1;i++){
            for(int j = i+1;j<n;j++){
                if(nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }
}

//Time Compl - O(n^2)
//Space Compl - O(1)

//Better
//Using hashing
//thought process - we want to reduce TC to O(nlogn or n)
//so think of iterating once in array
//if i'm at idx y, then i'm looking for target-y
//so if i can store previous number i can do it in one go

class Solution {
    public int[] twoSum(int[] nums, int target) {
        //Better - Using hasing
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            int rem = target - nums[i];
            if(map.containsKey(rem))
                return new int[]{map.get(rem), i};
            else
                map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}

//Time Compl - O(n or nlogn) depends on map
//Space Compl - O(n)

//Optimised - sort then use 2 pointers
//but only work when just want to return YES or NO
//cos after sorting elements with indexes gets distorted

class Solution {
    public String twoSum(int[] nums, int target) {
        int n = nums.length;
        int i = 0;
        int j = n-1;
        while(i<j){
            int sum = nums[i] + nums[j];
            if(sum == target)
                return "YES";
            else if(sum < target)
                i++;
            else
                j--;
        }
        return "NO";
    }
}

//Time Compl - O(n)
//Space Compl - O(1)