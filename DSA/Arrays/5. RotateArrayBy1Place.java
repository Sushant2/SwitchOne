//program to rotate an array by 1 place

//Brute Frocec
public static void rotateArray(int[] arr){
    int size = arr.length;
    int[] tempArr = new int[];
    tempArray[size-1] = arr[0];
    for(int i = 1;i<size;i++){
        tempArray[i-1] = arr[i];
    }

    //copying back to origianl array
    for(int i = 0;i<size;i++){
        arr[i] = tempArray[i];
    }
}

//Time Compl - O(n)
//Space Compl - O(n)

//Optimal Approach
public static void rotateArray(int[] arr){
    int temp = arr[0];
    for(int i = 0;i<arr.length;i++){
        arr[i] = arr[i+1];
    }
    arr[arr.length-1] = temp;
}
//Time Compl - O(n)
//Space Compl - O(1)