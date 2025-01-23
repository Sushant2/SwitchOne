//program to place C cows at given stalls such that minimum distance between any 2 cows is as maximum as possible

//Approach
//we know the minimum distance of placing 2 cows is when we place them one afte the other that is consecutively
//so we would sort the array such that we can find min distance between cows

//we can find the range from 1 to arr[size-1] - arr[0] as this would be the max distance if we place 2 cows at 2 ends

public class Solution {

    public static boolean canPlaceCows(int[] stalls, int dist, int k){
        int currCows = 1;
        int prevCow = stalls[0];
        for(int i = 1;i<stalls.length;i++){
            if(stalls[i] - prevCow >= dist){
                prevCow = stalls[i];
                currCows++;
            }
            if(currCows == k)
                    return true;
        }
        if(currCows == k)
            return true;
        return false;
    }
    
    public static int aggressiveCows(int []stalls, int k) {
        //    Write your code here.
        //range will be from 1 to arr[size-1] - arr[0] after sorting
        Arrays.sort(stalls);
        int MaxMinDis = Integer.MIN_VALUE;
        int low = 1, high = stalls[stalls.length-1] - stalls[0];
        for(int dist = low;dist<=high;dist++){
            boolean canPlace = canPlaceCows(stalls, dist, k);
            if(canPlace){
                MaxMinDis = Math.max(dist, MaxMinDis);
            }
        }
        return MaxMinDis;
    }
}


//time compl - O(n * n) + O(nlogn)for sorting
//space compl - O(1)

//using binary search
import java.util.*;
import java.io.*;
public class Solution {

    public static boolean canPlaceCows(int[] stalls, int dist, int k){
        int currCows = 1;
        int prevCow = stalls[0];
        for(int i = 1;i<stalls.length;i++){
            if(stalls[i] - prevCow >= dist){
                prevCow = stalls[i];
                currCows++;
            }
            if(currCows == k)
                    return true;
        }
        if(currCows == k)
            return true;
        return false;
    }
    
    public static int aggressiveCows(int []stalls, int k) {
        //    Write your code here.
        //range will be from 1 to arr[size-1] - arr[0] after sorting
        Arrays.sort(stalls);
        int MaxMinDis = Integer.MIN_VALUE;
        int low = 1, high = stalls[stalls.length-1] - stalls[0];
        
        while(low <= high){
            int midDist = low + (high-low)/2;
            if(canPlaceCows(stalls, midDist, k)){
                //goto right as to get max distance as possible
                MaxMinDis = Math.max(midDist, MaxMinDis);
                low = midDist + 1;
            }else{
                high = midDist - 1;
            }
        }
        
    
        return MaxMinDis;
    }
}

//time compl - O(logn*n) + O(nlogn) for sorting
//space compl - O(1)