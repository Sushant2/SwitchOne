// Bubble sort program
//push maximum ele at last by swapping adjacent elements

public static void bubbleSort(int[] arrayToSort){
    for(int index = arraySize - 1;index >= 0;index--){
        for(int secondIndex = 0;secondIndex<index;secondIndex++){
            if(arrayToSort[secondIndex] > arrayToSort[secondIndex+1])
                swap(arrayToSort, secondIndex, secondIndex+1);
        }
    }
}

//time compl - O(n^2) - worst & average
//time compl - O(n) - best when already sorted

// optimised code for best case

public static void bubbleSort(int[] arrayToSort){
    for(int index = arraySize - 1;index >= 0;index--){
        boolean didSwaps = false;
        for(int secondIndex = 0;secondIndex<index;secondIndex++){
            if(arrayToSort[secondIndex] > arrayToSort[secondIndex+1]){
                swap(arrayToSort, secondIndex, secondIndex+1);
                didSwaps = true;
            }
        }
        if(didSwaps == false)
            break;
    }
}