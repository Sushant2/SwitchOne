//program to merge 2 sorted arrays without extra space
// Input
//arr1[m] = [1, 3, 4, 6]
//arr2[n] = [0, 2, 5, 8, 9]

//merged array - [0, 1, 2, 3, 4, 5, 6, 8, 9]

//fill back ele to original array

// Output
//arr1[m] = [0, 1, 2, 3]
//arr2[n] = [4, 5, 6, 8, 9]

//brute force approach
//using extra space

public void merge(int[] arr1, int[] arr2){
    int m = arr1.length;
    int n = arr2.length;

    int[] temp = new int[m+n];

    int i = 0, j = 0, k = 0;
    while(i < m && j < n){
        if(arr1[i] <= arr2[j])
            temp[k++] = arr1[i++];
        else
            temp[k++] = arr2[j++];
    }

    //add remaining ele
    while(i<m)
        temp[k++] = arr1[i++];
    while(j<n)
        temp[k++] = arr2[j++];

    //add back ele to original array
    for(int i=0;i<m;i++)
        arr1[i] = temp[i];
    for(int i = 0;i<n;i++)
        arr2[i] = temp[m+i];
}

//time compl - O(m+n) + O(m+n)
//space compl - O(m+n)

//optimised approach
//if we notice arr1[m-1] > arr2[0], but we know acc to problem, arr1[m-1] should be on right side, so swap
//do this until one of the array is exhausted or arr1[m-1] <= arr1[i]

public void merge(int[] arr1, int[] arr2){

    int m = arr1.length;
    int n = arr2.length;
    int i = m-1, j = 0;
    while(i >= 0 && j < n){
        if(arr1[i] > arr2[j]){
            int temp = arr2[j];
            arr2[j] = arr1[i];
            arr1[i] = temp;
            i--;
            j++;
        }else
            break;
    }

    Arrays.sort(arr1);
    Arrays.sort(arr2);

}

//time compl - O(min(m, n)) + O(mlogm) + O(nlogn)
//space compl - O(1)


//optimal approach-2
//using gap method - intuition comes from sheel shorting
//initial gap = ceil(m+n/2) & later gap = gap/2 until gap>0
//keep 2 pointers gap elements apart, & check for greater & swaps

public void merge(int[] arr1, int[] arr2){

    int m = arr1.length;
    int n = arr2.length;

    int len = m+n;

    int gap = Math.ceil(len/2);

    while(gap > 0){
        int i = 0, j = i+gap;
        //do until j gets exhausted
        while(j < len){
            //ptrs in diff arr
            if(i<m && j>=m){
                swapIfGreater(arr1, arr2, i, j-m);
            }else if(j<m){
                //both ptrs in 1st arr
                swapIfGreater(arr1, arr1, i, j);
            }else{
                //both ptrs in 2nd arr
                swapIfGreater(arr2, arr2, i-m, j-m);
            }
            i++;
            j++;
        }
        if(gap == 1) break;
        gap = Math.ceil(gap/2);
    }
}

public void swapIfGreater(int[] arr1, int[] arr2, int i, int j){
    int temp = arr1[i];
    arr1[i] = arr2[j];
    arr2[j] = temp;
}

//time compl - O(log(m+n)) + O(m+n)
//space compl - O(1)