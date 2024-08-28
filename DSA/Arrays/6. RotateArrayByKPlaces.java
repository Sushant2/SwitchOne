//Program to roate an array by k places to the left

class Solution {
    public void rotate(int[] nums, int k) {
        int size = nums.length;
        if(k == size)
            return;
        k = k%size;
        int[] tempArr = new int[k];
        for(int i = 0;i<k;i++)
            tempArr[i] = nums[i];

        for(int i = k;i<size;i++)
            nums[i-k] = nums[i];

        for(int i = size-k;i<size;i++)
            nums[i] = tempArr[i-(size-k)];
    }
}

//Time Compl - O(n)
//Space Compl - O(n)

//Leetcode - 189 roate an array by k places to the right

class Solution {
    public void rotate(int[] nums, int k) {
        int size = nums.length;
        if(k == size)
            return;
        k = k%size;
        k = size-k; //only this add to rotate it by right
        int[] tempArr = new int[k];
        for(int i = 0;i<k;i++)
            tempArr[i] = nums[i];

        for(int i = k;i<size;i++)
            nums[i-k] = nums[i];

        for(int i = size-k;i<size;i++)
            nums[i] = tempArr[i-(size-k)];
    }
}
//Time Compl - O(n)
//Space Compl - O(n)
