//program to count reverse pair
//a reverse pair - i < j && arr[i] > 2*arr[j]

//Brute force
class Solution {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        for(int i = 0;i<n-1;i++){
            for(int j = i+1;j<n;j++){
                long num1 = (long)nums[i];
                long num2 = 2*(long)nums[j];
                if(num1 > num2)
                    cnt++;
            }
        }
        return cnt;
    }
}


//time compl - O(n^2)
//space compl - O(1)

//Optimal approach
//it is somewhat same as using mergesort just like counting inversion count
//but the logic is diff - as using logic of inversion count we'll miss out elements which can form reverse pair
//so we will count pairs separately before merging

class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    public int mergeSort(int[] arr, int low, int high){
        int cnt = 0;
        if(low >= high)
            return cnt;
        int mid = low + ((high-low)/2);
        cnt += mergeSort(arr, low, mid);
        cnt += mergeSort(arr, mid+1, high);
        cnt += findInvCnt(arr, low, mid, high);
        merge(arr, low, mid, high);
        return cnt;
    }

    public int findInvCnt(int[] arr, int low, int mid, int high){
        int right = mid+1;
        int cnt = 0;
        //for every element on left array we've find inversion count pair
        for(int i = low;i<=mid;i++){
            while(right <= high && arr[i] > (2*(long)arr[right]))
                right++;
            cnt += (right-(mid+1));
        }
        return cnt;
    }

    public int merge(int[] arr, int low, int mid, int high){
        int left = low;
        int right = mid+1;
        //[loop...mid] [mid+1...high]
        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                list.add(arr[left]);
                left++;
            }else{
                list.add(arr[right]);
                if(arr[left] > (2*arr[right]))
                    cnt += (mid-left+1);
                right++;
            }
        }
        //add rem ele
        while(left <= mid){
            list.add(arr[left]);
            left++;
        }
        while(right <= high){
            list.add(arr[right]);
            right++;
        }

        //add back ele to original array
        // i = low intially then, low-low = 0
        // i = low+1 then, low+1-low = 1
        // i = low+2 then, low+2-low = 2
        // so on...
        for(int i = low;i<=high;i++)
            arr[i] = list.get(i-low);
        return cnt;
    }
}

//time compl - O(nlogn) + O(n)
//space compl - O(n)