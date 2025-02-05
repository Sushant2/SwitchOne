//program to minimize the maximum distance between gas stations


//BRUTE FORCE
public class Solution {
    public static double MinimiseMaxDistance(int []stations, int k){
        // Brute Force
        int len = stations.length;
        //eg : if need to place 2 new station between any 2 old stations
        //1___.___.___10 so, n stations and n-1 distance
        int[] howManyPlaced = new int[len-1];
        //need to place each gas station
        for(int gasi = 1;gasi <= k;gasi++){
            //find the maxDis between stations that we need to minimize & where the distance is
            double maxDis = -1; int maxIdx = -1;
            for(int i = 0;i<len-1;i++){
                //initial distance in between
                double diff = stations[i+1] - stations[i];
                //actual distance after placing station in between the above distance
                double sectionLen = (double)diff / (double)(howManyPlaced[i] + 1); //eg, if 2 placed, then there will be 3 distance
                if(maxDis < sectionLen){
                    maxDis = sectionLen;
                    maxIdx = i;
                }
            }
            //place the station between maxDis
            howManyPlaced[maxIdx]++;
        }
        //after placing all stations
        //the minimum distance
        double minAns = -1;
        for(int i = 0;i<len-1;i++){
            double sectionLen = (double)(stations[i+1] - stations[i]) / (double)(howManyPlaced[i]+1);
            minAns = Math.max(minAns, sectionLen);
        }
        return minAns;
    }
}
//time compl - O(k*n) + O(n)
//space compl - O(1)

//Better approach
//optimising the time complexity - as we can get rid of inner loop which tries to find the maximum distance every time using MAXHEAP priority que

import java.util.*;
import java.io.*;
public class Solution {
    public static class Pair{
        double maxDis;
        int maxIdx;
        
        
        Pair(double maxDis, int maxIdx){
            this.maxDis = maxDis;
            this.maxIdx = maxIdx;
        }
    }
    public static double MinimiseMaxDistance(int []stations, int k){
         // Better Approach - using priority queue - max heap
        int len = stations.length;
        //eg : if need to place 2 new station between any 2 old stations
        //1___.___.___10 so, n stations and n-1 distance
        int[] howManyPlaced = new int[len-1];
        PriorityQueue<Pair> que = new PriorityQueue<>((a, b) -> Double.compare(b.maxDis, a.maxDis));
        //initially assign all distance and their idx in PQ
        for(int i = 0;i<len-1;i++){
            double dist = (double)(stations[i+1] - stations[i]);
            que.add(new Pair(dist, i));
        }

        //need to place each gas station
        for(int gasi = 1;gasi <= k;gasi++){
            //get the maxDist and its idx from  PQ
            Pair currPair = que.poll();
            int maxIdx = currPair.maxIdx;
            howManyPlaced[maxIdx]++;
            
            //now insert the currMaxDist and its idx after placing the new station
            double initialDiff = stations[maxIdx + 1] - stations[maxIdx];
            double currMaxDist = (initialDiff) / (double)(howManyPlaced[maxIdx]+1);
            que.add(new Pair(currMaxDist, maxIdx));
            
        }
        //after placing all stations
        //the minimum distance
        return (double)que.peek().maxDis;
    }
}

//time compl - O(nlogn) + O(k*logn)
//space compl - O(n-1) in PQ

//using BINARY SEARCH
//reducing space complexity

public class Solution {
    public static int getHowManyPlaced(double dist, int[] arr){
        int totalStationsPlaced = 0;
        //run for all section length
        for(int i = 1;i<arr.length;i++){
            int noOfStations = (int)((arr[i] - arr[i-1])/dist);
            //check edge case - when completely divisble, means 1 less station will be placed
            if((arr[i] - arr[i-1]) == (dist * noOfStations))
                noOfStations -= 1;
            totalStationsPlaced += noOfStations;
        }
        return totalStationsPlaced;
    }
    public static double MinimiseMaxDistance(int []arr, int K){
        //Using Binary Search
        //our range will be from 0 to maxDist between two consecutive stations
        int len = arr.length;
        double low = 0;
        double high = 0;
        for(int i = 0;i<len-1;i++){
            high = Math.max(high, (double)(arr[i+1]-arr[i]));
        }

        //instead of normal binary search for integers, we'll do it for decimal with some tweaks
        //as to return answer in decimal : Answers within 10^-6 of the actual answer will be accepted.
        double diff = 1e-6;
        while(high - low > diff){
            double midDist = (low+high)/(2.0);
            int howManyPlaced = getHowManyPlaced(midDist, arr);
            if(howManyPlaced > K){
                //if more required for midDist - goto right
                low = midDist;
            }else{
                high = midDist;
            }
        }
        return high; //can return either low or high as their difference is beyond 10^(-6)
    }
}

//time compl - O(n) + O(logn*n)
//space compl - O(1)