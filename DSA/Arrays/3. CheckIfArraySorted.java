// Easy version -

public boolean check(int[] nums) {
    if(nums.length == 1)
        return true;
    for(int i = 1;i<nums.length;i++)
        if(arr[i] < arr[i-1])
            return false;

    return true;
}
//Time Compl - O(n)
//Space Compl - O(1)

//LeetCode - 1752

//My Approach - i traversed the array in circular motion, if from any index i find the array sorted(till size of array) - then return true
//Leetcode Approach - Just find array in descreasing order more than once & just check at the end - if the last ele is greater than first - return false
public boolean check(int[] nums) {
        int size = nums.length;
         if(size == 1)
            return true;
        int count = 1;
        for(int i = 1;i<2*size;i++){
            //iterating array in circular fashion
            //(i%size) - to get the current index circularly
            //(i-1)%size - to get previous index circularly
            if(nums[i%size] >= nums[(i-1)%size]){
                count++;
                if(count == size)
                    return true;
            }else
                count = 1;
        }
    return false;
}

//Time Compl - O(n)
//Space Compl - O(1)

//Better Approach

public boolean check(int[] nums) {
    int size = nums.length;
    if(size == 1)
        return true;
    int count = 0;

    if(nums[size-1] > nums[0])
        count++;

    for(int i = 0;i<size-1;i++){
        if(nums[i]> nums[i+1])
            count++;
        if(count > 1)
            return false;
    }
    return true;
}

//Time Compl - O(n)
//Space Compl - O(1)