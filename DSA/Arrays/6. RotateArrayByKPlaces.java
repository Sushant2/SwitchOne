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


//Using the observation ki each part ko reverse krne se, rotate ho jaa rha h array
//so using recursion - which doesn't require any extra space

class Solution {
    public void reverse(int[] arr, int left , int right){
        if(left >= right)
            return;
        //swap
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        reverse(arr, left+1, right-1);
    }
    public void rotate(int[] nums, int k) {
        int size = nums.length;
        int[] temp = new int[size];
        
        if(size==1) return;
        k = k%size;

        reverse(nums, 0, size-k-1);
        reverse(nums, size-k, size-1);
        reverse(nums, 0, size-1);
    }
}

//time compl - O(n)
//space compl - O(1)