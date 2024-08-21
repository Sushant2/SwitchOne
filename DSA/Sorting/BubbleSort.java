// Bubble sort program

public static void bubbleSort(int[] arrayToSort){
    for(int index = arraySize - 1;index >= 0;index--){
        for(int secondIndex = 0;secondIndex<index;secondIndex++){
            if(arrayToSort[secondIndex] > arrayToSort[secondIndex+1])
                swap(arrayToSort, secondIndex, secondIndex+1);
        }
    }
}

//time compl - O(n^2)