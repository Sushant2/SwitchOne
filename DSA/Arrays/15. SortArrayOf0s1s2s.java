//program to sort an array of 0s, 1 & 2s

//Brute force
class Solution {
    public void sortColors(int[] nums) {
        //Brute Force
        Arrays.sort(nums);
    }
}

//Time Compl - O(nlogn)
//Space Compl - O(1)

//Better

class Solution {
    public void sortColors(int[] nums) {
        //Better
        int cnt0 = 0;
        int cnt1 = 0;
        int cnt2 = 0;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            if(nums[i] == 0)
                cnt0++;
            else if(nums[i] == 1)
                cnt1++;
            else
                cnt2++;
        }

        for(int i = 0;i<cnt0;i++)
            nums[i] = 0;
        for(int i = cnt0;i<(cnt0+cnt1);i++)
            nums[i] = 1;
        for(int i = (cnt0+cnt1);i<n;i++)
            nums[i] = 2;
    }
}

//Time Compl - O(2n)
//Space Compl - O(1)

//Optimised - Using 3 pointers - Duth National Flag Algo

class Solution {
    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void sortColors(int[] nums) {
        //Optimised
        int n = nums.length;
        int low = 0;
        int mid = 0;
        int high = n-1;
        while(mid <= high){
            if(nums[mid] == 0){
                swap(nums, low, mid);
                low++;
                mid++;
            }
            else if(nums[mid] == 1)
                mid++;
            else if(nums[mid] == 2){
                swap(nums, mid, high);
                high--;
            }
        }
    }
}

//Time Compl - O(n)
//Space Compl - O(1)