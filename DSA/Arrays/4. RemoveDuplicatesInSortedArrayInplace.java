//program to remove duplicates ele from sorted array in-place

//Leetcode - 26

//My 1st approach - 
//takes an extra array to keep unique elements
//takes a counter variable to count unique elements
public int removeDuplicates(int[] nums) {
    int size = nums.length;
    if(size == 1)
        return 1;
    int[] tempArray = new int[size];
    int cntUnique = 1;
    tempArray[0] = nums[0];

    for(int i = 1;i<size;i++){
        if(tempArray[cntUnique-1] != nums[i]){
            tempArray[cntUnique++] = nums[i];
        }
    }
    //copy back ele from tempArray to nums
    for(int i = 0;i<cntUnique;i++){
        nums[i] = tempArray[i];
    }
    return cntUnique;
}

//Time Compl - O(n)
//Space Compl - O(n)

//My 2nd approach - 
//remove that extra array with a variable
public int removeDuplicates(int[] nums) {
    int size = nums.length;
    if(size == 1)
        return 1;
    int tempEle = nums[0];
    int cntUnique = 1;

    for(int i = 1;i<size;i++){
        if(tempEle != nums[i]){
            nums[cntUnique++] = nums[i];
            tempEle = nums[i];
        }
    }
    return cntUnique;
}

//Time Compl - O(n)
//Space Compl - O(1)

//Striver Approach
//Using 2 pointers
public int removeDuplicates(int[] nums) {
    int i = 0;
    for(int j = 1;j<nums.length;j++){
        if(nums[i] != nums[j]){
            nums[++i] = nums[j];
        }
    }
    return i+1;
}
//Time Compl - O(n)
//Space Compl - O(1)