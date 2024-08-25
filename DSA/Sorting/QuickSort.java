// Quick Sort Program

public static int partition(int[] arr, int low, int high){

    int pivot =  low;
    int left = low;
    int right = high;

    //do this for the currect array/subarray until right crosses left
    while(left < right){
        //find greater than pivot from left
        //find smaller than pivot from right
        //swap them
        while(arr[pivot] >= arr[left] && left < high)
            left++;
        while(arr[pivot] < arr[right] && right > low)
            right--;

        if(left < right)
            swap(arr, left, right);
        
    }
    //now when right crosses left, we got the pivot's correct place which is "right" index
    swap(arr, pivot, right);
    return right; //which is partition index
}

public static void sortArray(int[] arr, int low, int high){
    if(low >= high)
        return;
    // [[low...partition-1][partition][partition+1...high]]
    int partitionIndex = partition(arr, low, high);
    sortArray(arr, low, partitionIndex-1);
    sortArray(arr, partitionIndex+1, high);
}


public static void quickSort(int[] arr, int size){
    sortArray(arr, 0, size-1);
}