//write a program to find kth integer missing from array

//my brute force 
class Solution {
    public int findKthPositive(int[] arr, int k) {
        //Linear Solution
        //base case
        if(k < arr[0]) return k;
        int x = k;
        Set<Integer> set = new HashSet<>();
        for(int e : arr)
            set.add(e);
        for(int i = 1;i<=(arr[arr.length-1]+k);i++){
            if(!set.contains(i)){
                x--;
            }
            if(x==0)
                return i;
        }
        return -1;
    }
}

//time compl - O(n)
//space compl - O(n)


//Striver's Brute Force
//arr[] = [2, 3, 4, 5]
//appraoach - suppose all numbers are missing initially
// if all numbers are missing then 5th missing number is itself my ans
// but what if i've now 1 number that is not missing in the array , so now my ans 5 becomes 6
//as [2], k = 5 so,  ans = 6
//similary now if i've [2, 3], then my ans will be 7
//and so on.... till i didn't find any number greater than ans
//try doing once in notebook


class Solution {
    public int findKthPositive(int[] arr, int k) {
        //Linear Solution
        //base case
        if(k < arr[0]) return k;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] <= k) k++;
            else break;
        }
        return k;
    }
}

//time compl - O(n)
//space compl - O(1)

//binary search
//we can't apply tipical binary search nor we can apply binary search on answers, as there is no range of possible ans notpossible ans
//but we can think of apply binary search as the array is sorted

//appoach
//if somehow i can figureout where my kth missing no will lie, i need to find the nearby indexes to my ans
//if we observe
//arr[] = [3, 4, 5, 8, 11]
//      = [1, 2, 3, 4, 5, 6, 7...] ideally if no numbers were missing my array would be like this
//so i can find how many numbers are missing till that index as : missNoTill0index = arr[0] - 1 => 3-1 = 2, 2 numbers are missing at index 0

//so likewise my all missing numbers array will be-
//      = [2, 2, 2, 4, 6]
//so to find 5th missing no, it'll lie between 4 & 6, thats how i can find 2 nearby indexes to my ans

class Solution {
    public int findKthPositive(int[] arr, int k) {
        //Binary Search Solution
        //edge case
        if(k < arr[0]) return k;;
        int low = 0, high = arr.length-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            int missNoTillmididx = arr[mid] - (mid+1);
            if(missNoTillmididx < k){
                //goto right
                low = mid+1;
            }else{
                //goto left
                high = mid-1;
            }
        }
        //now binary search stops, low crosses high & we found are 2 neighbour indeces where are answer can be
        //ans lies = arr[high] + moreMissNos that we want
        
        //formulate the ans
        //we know missNoTillmididx = arr[mid] - (mid+1)
        //and we're at high, so missNoTillhighidx = arr[high] - (high+1)
        //we know moreMissNos = k - missNoTillThatIdx
        //so moreMissNos = k - (arr[high] - (high+1))
        //now, ans = arr[high] + k - arr[high] + high + 1
        // ans = k + high + 1

        return (k +high+1);  
    }
}


//time compl - O(logn)
//space compl - O(1)