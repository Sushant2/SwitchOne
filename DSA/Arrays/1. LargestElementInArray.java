// Largest element in array program

public static int largest(int[] arr) {
        // code here
        if(arr.length == 1)
            return arr[0];
        int max = arr[0];
        for(int i = 1;i<arr.length;i++)
            if(arr[i] > max)
                max = arr[i];
                
        return max;
}

// time compl - O(n)
// space compl - O(1)