//program to move all zeroes at the end inplace

//Brute Force - using extra array & storing all nonzeroes there & moving back from there to original array

class Solution {
    public void moveZeroes(int[] nums) {
        int size = nums.length;
        if(size <= 1)
            return;
        ArrayList<Integer> tempArr = new ArrayList<>();
        for(int i = 0;i<size;i++){
            if(nums[i] != 0)
                tempArr.add(nums[i]);
        }
        for(int i = 0;i<tempArr.size();i++)
            nums[i] = tempArr.get(i);
        for(int i = tempArr.size();i<size;i++)
            nums[i] = 0;
    }
}

//Time Compl - O(n)
//Space Compl - O(n)


//Optimised - using 2 pointers
//step 1: find first zero index & start iterating from there - my intuition also samme
//then find first nonzero index after that zero index & then swap

class Solution {

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void moveZeroes(int[] nums) {
        int size = nums.length;
        if(size <= 1)
            return;
        int zeroPtr = -1;
        for(int i = 0;i<size;i++){
            if(nums[i] == 0){
                zeroPtr = i;
                break;
            }
        }

        if(zeroPtr == -1)
            return;

        for(int nonZeroPtr = zeroPtr+1;nonZeroPtr<size;nonZeroPtr++){
            if(nums[nonZeroPtr] != 0){
                swap(nums, zeroPtr, nonZeroPtr);
                zeroPtr++;
            }
        }
    }
}

//Time Compl - O(n)
//Space Compl - O(1)
