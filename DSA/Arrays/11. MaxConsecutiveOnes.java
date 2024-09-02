//program to find maximum consecutive ones in array

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int cntOne = 0;
        int maxCnt = 0;
        for(int i = 0;i<n;i++){
            if(nums[i] == 1)
                cntOne++;
            else{
                if(maxCnt < cntOne)
                    maxCnt = cntOne;
                cntOne = 0;
            }
        }
        return cntOne > maxCnt ? cntOne : maxCnt;
    }
}

//Time Compl - O(n)
//Space Compl - O(1)