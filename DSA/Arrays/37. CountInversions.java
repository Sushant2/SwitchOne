//program to count inversion
//an inversion is a pair of ele when arr[i] > arr[j] & i < j

//Brute Force

class Solution {
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        int n = arr.length;
        int cnt = 0;
        for(int i = 0;i<n-1;i++){
            for(int j = i+1;j<n;j++){
                if(arr[i] > arr[j])
                    cnt++;
            }
        }
        return cnt;
    }
}

//time compl - O(n^2)
//space compl - O(1)

//optimal
//we'll count inversion sort while merging in merge sort
//try intution - suppose we've 2 sorted arrays & we need to merge them
//if you notice if arr[i] > brr[j], then all elements after arr[i] in right will also be > brr[j]
//so we just need to add a condition in merge sort to calculate inserion count

class Solution {
    // Function to count inversions in the array.
    public static int merge(int[] arr, int low, int mid, int high){
        int left = low;
        int right = mid+1;
        //two arrays are like [low...mid] [mid+1...high]
        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        while(left<=mid && right<=high){
            if(arr[left] <= arr[right]){
                list.add(arr[left]);
                left++;
            }else{
                //where arr[left] > arr[right] - here we can calculate inversion
                list.add(arr[right]);
                right++;
                cnt += (mid-left+1);
            }
        }

        //add remaining ele to list
        while(left<=mid){
            list.add(arr[left]);
            left++;
        }
        while(right<=high){
            list.add(arr[right]);
            right++;
        }

        //add back to array
        for(int i = low;i<=high;i++)
            arr[i] = list.get(i-low);
            
        return cnt;
    }
    public static int mergeSort(int[] arr, int low, int high){
        int cnt = 0;
        if(low >= high)
            return cnt;
        int mid = (low+high)/2;
        cnt += mergeSort(arr, low, mid);
        cnt += mergeSort(arr, mid+1, high);
        cnt += merge(arr, low, mid, high);
        return cnt;
    }
    static int inversionCount(int arr[]) {
        int cntInv = mergeSort(arr, 0, arr.length-1);
        return cntInv;
    }
}

//time compl - O(nlogn)
//space - O(n) to store the merged array