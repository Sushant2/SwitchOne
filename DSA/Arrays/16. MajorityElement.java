//program to find majority element who appears more than floor of(n/2) times

//Brute Force

class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int threshold = (int) Math.floor(n/2);
        for(int i = 0;i<n;i++){
            int cnt = 0;
            for(int j = 0;j<n;j++){
                if(nums[i] == nums[j]){
                    cnt++;
                    if(cnt > threshold)
                        return nums[i];    
                }
            }
        }
        return -1;
    }
}

//Time Compl - O(n^2)
//Space Compl - O(1)

//Better
//Using hasmap to count the no of element
//iterating hashmap to find majority ele

class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int threshold = (int) Math.floor(n/2);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            int val = map.getOrDefault(nums[i], 0);
            map.put(nums[i], val+1);
        }
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            if(e.getValue() > threshold)
                return e.getKey();
        }
        return -1;
    }
}

//Time Compl - O(n*logn) + O(n)
//Space Compl - O(n)


//Optimised
//USING MOORE'S VOTING ALGORITHM

class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int threshold = (int) Math.floor(n/2);
        int ele = nums[0];
        int cnt = 1;
        for(int i = 1;i<n;i++){
            if(cnt == 0){
                ele = nums[i];
                cnt = 1;
            }
            else if(nums[i] == ele)
                cnt++;
            else
                cnt--;
        }
        return ele;
    }
}

//Time Compl - O(n)
//Space Compl - O(1)