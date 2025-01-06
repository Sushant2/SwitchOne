//You are given 2 numbers n and m, the task is to find n√m (nth root of m). If the root is not integer then returns -1.

//Using Binary Search on answers

class Solution {
    public int nthRoot(int n, int m) {
        int low = 1, high = m;
        while(low <= high){
            long mid = low + (high-low)/2;
            long sum = 1;
            for(int i = 0;i<n;i++)
                sum *= mid;
            
            if(sum == m){
                return (int)mid;
            }else if(sum < m){
                low = (int)mid+1;
            }else{
                high = (int)mid-1;
            }
        }
        return -1;
    }
}

//time compl - O(logm) * O(n)


//i can write a function to calculate power of mid instead of multiplying n times
//we know following and using this we wi'll write function as to avoid overflow of integer while multiplying
//return 0 if sum == m
//return 1 if sum > m
//return 2 if sum < m

class Solution {

    public long func(int mid, int n, int m){
        long sum = 1;
        for(int i = 1;i<=n;i++){
            sum *= mid;
            if(sum > m)
                return 1;
        }
        if(sum == m)
            return 0;
        return 2;
    }
    public int nthRoot(int n, int m) {
        int low = 1, high = m;
        while(low <= high){
            int mid = low + (high-low)/2;
            long sum = func(mid, n, m);

            if(sum == 0){
                return mid;
            }else if(sum == 2){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }
}

//time compl is same as above, it just handles the overflow while multiplication