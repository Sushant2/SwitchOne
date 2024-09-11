//Program to return the array of nums such that the the array follows the given conditions:
// - Every consecutive pair of integers have opposite signs.
// - For all integers with the same sign, the order in which they were present in nums is preserved.
// - The rearranged array begins with a positive integer.

//leetcode - 2149
//Brute Force
class Solution {
    public int[] rearrangeArray(int[] nums) {
        //Brute Force
        int n = nums.length;
        int[] arrPos = new int[n/2];
        int[] arrNeg = new int[n/2];
        int i = 0;
        int j = 0;
        for(int ele : nums){
            if(ele > 0)
                arrPos[i++] = ele;
            else
                arrNeg[j++] = ele;
        }
        int[] res = new int[n];
        i = 0;
        while(i<n/2){
            //2*i - always even 
            //2*i+1 - always odd
            res[2*i] = arrPos[i];
            res[2*i+1] = arrNeg[i];
            i++;
        }
        return res;
    }
}

//Time Compl - O(2n)
//Space Compl - O(n)

//Better
//Observer tha
//pos numbers are in even indexes - 0, 2, 4...
//neg numbers are in odd indexes - 1, 3, 5...
//so take 2 ponters pos & neg inc them by 2, whenever you get a +ve or neg
class Solution {
    public int[] rearrangeArray(int[] nums) {
        //Better Force
        int n = nums.length;
        int[] res = new int[n];
        int pos = 0;
        int neg = 1;
        for(int i = 0;i<n;i++){
            if(nums[i] > 0){
                res[pos] = nums[i];
                pos += 2;
            }else{
                res[neg] = nums[i];
                neg += 2;
            }
        }
        return res;
    }
}

//Time Compl - O(n)
//Space Compl - O(1)

//Another variety where - no of pos & no of negs are not equal
//so add rem elements in same order as in original array
//eg - input : [-1, 2, 3, 4, -3, 1]
//output : [2, -1, 3, -3, 4, 1]

//Optimal approach will not work, it will onyl work where no of pos & no of negs are equal
//so use brute force approach


class Solution {
    public int[] rearrangeArray(int[] nums) {
        //Brute Force
        int n = nums.length;
        ArrayList<Integer> arrPos = new ArrayList<>();
        ArrayList<Integer> arrNeg = new ArrayList<>();
        for(int ele : nums){
            if(ele > 0)
                arrPos.add(ele);
            else
                arrNeg.add(ele);
        }
        int[] res = new int[n];
        int arrNegSize = arrNeg.size();
        int arrPosSize = arrPos.size();
        if(arrPosSize > arrNegSize){
            for(int i = 0;i<arrNegSize;i++){
                res[i*2] = arrPos.get(i);
                res[i*2+1] = arrNeg.get(i);
            }
            //add remaining positive numbers
            int idx = arrNegSize*2;
            for(int i = arrNeg;i<arrPosSize;i++)
                res[idx++] = arrPos.get(i);
        }else{
            for(int i = 0;i<arrPosSize;i++){
                res[i*2] = arrPos.get(i);
                res[i*2+1] = arrNeg.get(i);
            }
            //add remaining positive numbers
            int idx = arrPosSize*2;
            for(int i = arrPosSize;i<arrNegSize;i++)
                res[idx++] = arrNeg.get(i);
        }

        return res;
    }
}

//Time Compl - O(2n)
//Space Compl - O(n)
