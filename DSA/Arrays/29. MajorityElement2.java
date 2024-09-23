//Program to find all elements those who appears more than floor(n/3) times in array

//Brute Force
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //Brute Force
        int n = nums.length;
        int mini = (int)Math.floor(n/3);
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<n;i++){
            if(list.size() == 0 || list.get(0) != nums[i]){
                int cnt = 1;
                for(int j = 0;j<n;j++){
                    if(i != j && nums[i] == nums[j])
                        cnt++;
                }
                if(cnt > mini)
                    list.add(nums[i]);
                if(list.size() == 2)
                    break;
            }
        }
        return list;
    }
}

//Time Compl - O(n^2)
//Space Compl - O(1)


//Better - using hashing
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //Better Force
        int n = nums.length;
        int mini = (int)Math.floor(n/3);
        
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            int val = map.getOrDefault(nums[i], 0);
            map.put(nums[i], val+1);
        }

        for(Map.Entry<Integer, Integer> it : map.entrySet()){
            if(it.getValue() > mini)
                list.add(it.getKey());
            if(list.size() == 2)
                break;
        }

        return list;
    }
}

//Time Compl - O(2n)
//Space Compl - O(n)

//NOW WE CAN DO MORE BETTER AS THERE IS NO NEED TO ITERATE AGAIN IN MAP
//WHILE INSERTING ELEMENTS IN MAP, IF WE CAN CHECK COUNT > MINI
//LIST.ADD(NUMS[I])


class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //Better Force
        int n = nums.length;
        int mini = (int)Math.floor(n/3);
        
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            int val = map.getOrDefault(nums[i], 0);
            map.put(nums[i], val+1);
            if(map.get(nums[i]) > mini){
                // Add only if it's not already in the list
                if (!list.contains(nums[i]))
                    list.add(nums[i]);
            }
            if(list.size() == 2)
                break;
        }

        return list;
    }
}

//Time Compl - O(n)
//Space Compl - O(n)



//Optimised using MOORES VOTING ALGORITHM
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //Optimised
        int n = nums.length;
        int mini = (int)Math.floor(n/3);
        
        int cnt1 = 0, cnt2 = 0;
        int ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;

        for(int i = 0;i<n;i++){
            if(cnt1 == 0 && nums[i] != ele2){
                cnt1 = 1;
                ele1 = nums[i];
            }
            else if(cnt2 == 0 && nums[i] != ele1){
                cnt2 = 1;
                ele2 = nums[i];
            }else if(ele1 == nums[i]){
                cnt1++;
            }
            else if(ele2 == nums[i]){
                cnt2++;
            }else{
                cnt1--;
                cnt2--;
            }
        }

        //now confirm that these 2 elements are the majority elements
        cnt1 = 0; cnt2 = 0;
        for(int i = 0;i<n;i++){
            if(nums[i] == ele1)
                cnt1++;
            else if(nums[i] == ele2)
                cnt2++;
        }
        List<Integer> list = new ArrayList<>();
        if(cnt1 > mini)
            list.add(ele1);
        if(cnt2 > mini)
            list.add(ele2);

        return list;
    }
}

//Time Compl - O(n)
//Space Compl - O(1)