//Merge Sort Program

public static void merge(int[] arr, int low, int mid, int high){
    int left = low;
    int right = mid+1;
    //[low...mid]
    //[mid+1...high]
    ArrayList<Integer> tempArr = new ArrayList<>();
    while(left <= mid && right <= high){
        if(arr[left] <= arr[right]){
            tempArr.add(arr[left]);
            left++;
        }
        else{
            tempArr.add(arr[right]);
            right++;
        }
    }
    //add rem elements
    while(left<=mid){
        tempArr.add(arr[left]);
        left++;
    }
    while(right<=high){
        tempArr.add(arr[right]);
        right++;
    }

    //insert back tempArr to arr
    for(int i = low;i<=high;i++){
        arr[i] = tempArr.get(i-low);
    }
}

public static void divideArray(int[] arr, int low, int high){
    //base condition
    if(low >= high)
        return;
    int mid = (low+high)/2;
    divideArray(arr, low, mid);
    divideArray(arr, mid+1, high)
    merge(arr, low, mid, high);
}

public static void mergeSort(int[] arrayToSort, int size){
    divideArray(arrayToSort, 0, size-1);
}



//Time Compl - O(nlogn)
//Space Compl - O(n)