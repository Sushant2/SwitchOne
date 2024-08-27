// selection sort program
//select the minimum & bring it forward

public static void selectionSort(int[] arrayToSort){
    for(int index = 0;index<n-1;index++){
        int minIndex = index;
        for(int secondIndex = index+1;secondIndex<n;secondIndex++){
            if(arrayToSort[minIndex] > arrayToSort[secondIndex])
                minIndex = secondIndex;
        }
        swap(int[] arrayToSort, int minIndex, int index);
    }
}

//time compl - O(n^2)
