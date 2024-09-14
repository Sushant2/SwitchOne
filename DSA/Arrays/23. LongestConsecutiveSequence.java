//Program to find longest consecutive sequence

//Brute Force
//for each ele, find its next ele in arr

class Solution {
    public boolean linearS(int[] arr, int ele){
        for(int e : arr)
            if(e == ele)
                return true;
        return false;
    }
    public int longestConsecutive(int[] nums) {
        //Better
        int n = nums.length;
        if(n <=1)
            return n;
        int maxSeq = 1;
        for(int i = 0;i<n;i++){
            int curr = nums[i];
            int currSeq = 1;
            while(linearS(nums, curr+1)){
                curr++;
                currSeq++;
            }
            maxSeq = Math.max(maxSeq, currSeq);
        }
        return maxSeq;
    }
}

//Time Compl - O(n^2)
//Space Compl - O(1)

//Better
//Sort array - as we want consecutive seq
class Solution {
    public int longestConsecutive(int[] nums) {
        //Better
        int n = nums.length;
        if(n <= 1)
            return n;
        int maxSeq= 1;
        int currEle = Integer.MIN_VALUE;
        int currSeq = 0;
        Arrays.sort(nums);

        for(int i = 0;i<n;i++){
            if(currEle == nums[i] - 1){
                currEle = nums[i];
                currSeq++;
            }
            else if(currEle != nums[i]){
                currEle = nums[i];
                currSeq = 1;
            }
            maxSeq = Math.max(maxSeq, currSeq);
        }
        return maxSeq;
    }
}

//Time Compl - O(nlogn) + O(n)
//Space Compl - O(1)

//Optimal using Set
//store all ele in set
//for arr[i] - look for its previous, if it exist do not start count from arr[i]
//we need to start counting from first ele

class Solution {
    public int longestConsecutive(int[] nums) {
        //Optimal - using set
        Set<Integer> set = new HashSet<>();
        for(int ele : nums)
            set.add(ele);

        if(nums.length <= 1)
            return nums.length;

        int maxSeq = 1;
        for(int ele : set){
            if(!set.contains(ele-1)){
                int currEle = ele;
                int currSeq = 1;
                while(set.contains(currEle+1)){
                    currEle++;
                    currSeq++;
                }
                maxSeq = Math.max(maxSeq, currSeq);
            }
        }
        return maxSeq;
    }
}

//Time Compl - O(n) + O(n)
//Space Comp - O(n)
