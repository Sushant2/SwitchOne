//Program to find a number that appears once in array, where rest elements appears twice

//Brute force
class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        //using hashing
        if(n==1)
            return nums[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            int val = map.getOrDefault(nums[i], 0);
            map.put(nums[i], val+1);
        }
        for(Map.Entry<Integer, Integer> it : map.entrySet()){
            if(it.getValue() == 1)
                return it.getKey();
        }

        return 0;
    }
}

//insert n elements in array - insertion in map takes logm
//Time Compl - O(n.logm) + O(m)
//Space Compl - O(m)

//Optimised
//Using XOR
//a^a = 0
//0^a = a
//a^0 = a

class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        //using hashing
        if(n==1)
            return nums[0];
        int xor = 0;
        for(int i = 0;i<n;i++){
            xor = xor^nums[i];
        }
        return xor;
    }
}

//Time Compl - O(n)
//Space Compl - O(1)