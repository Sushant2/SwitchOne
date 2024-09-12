//Program to find next permutation of the given array

//Brute Force
//Generate all permutations & find the next one for your given array using linear search
//If the given array is at last, return first one

//it is time taking
//as to find all permutation of a number = n!
// eg - 5! = 120, 15! - 10^12

//we can generate all perms using recursion

//Time Compl - O(n!*n)
//Space Compl - O(n)

//Optimal Approach

// LC-31

class Solution {
    public void reverse(int[] arr, int i, int j){
        while(i <= j){
            swap(arr, i, j);
            i++;
            j--;
        }
    }
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void nextPermutation(int[] nums) {
        //Optimal Approach
        //find a breakpoint
        int n = nums.length;
        int breakP = -1;
        for(int i = n-2;i>=0;i--){
            if(nums[i] < nums[i+1]){
                breakP = i;
                break;
            }
        }
        if(breakP == -1){
            reverse(nums, 0, n-1);
            return;
        }
        //find a smallest ele from right but bigger than nums[breakP]
        int nextBig = -1;
        for(int i = n-1;i>breakP;i--){
            if(nums[i] > nums[breakP]){
                nextBig = i;
                break;
            }
        }
        //swap breakpoint with that number
        swap(nums, breakP, nextBig);
        //now reverse the remaining array after breakpoint
        reverse(nums, breakP+1, n-1);
    }
}

//Time Compl - O(3n)
//Space Compl - O(1)