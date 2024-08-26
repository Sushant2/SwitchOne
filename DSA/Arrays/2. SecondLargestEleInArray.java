// Second Largest Element in Array

public int print2largest(int[] arr) {
        int max = arr[0];
        int sMax = 0;
        for(int i = 1;i<arr.length;i++){
            if(max < arr[i]){
                sMax = max;
                max = arr[i];
            }
            else if(arr[i] != max && sMax < arr[i])
                sMax = arr[i];
        }
        if(sMax == max)
            return -1;
        return sMax;
}

// time compl - O(n)
// space compl - O(1)

