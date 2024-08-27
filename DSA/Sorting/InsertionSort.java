// Insertion sort program
//first ele is always at its right place

public static void insertionSort(int[] arrayToSort){
    for(int index = 0;index<=n-1;index++){
        int secondIndex = index;
        while(secondIndex > 0 && arrayToSort[secondIndex] < arrayToSort[secondIndex-1]){
            swap(arrayToSort, secondIndex, secondIndex-1);
            j--;
        }
    }
}