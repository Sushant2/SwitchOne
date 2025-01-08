//Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.

//first try to write a function to check is it is possible to create m bouquets in d day

//Brute force
//Linear Solution

class Solution {
    //function to check if day d is possible to make m bouquets or not
    public boolean isPossible(int[] arr, int d, int m, int k){
        int ctr = 0, totalBouquets = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] <= d){
                //when flower is blooming
                ctr++;
            }else{
                //flower not blooming
                totalBouquets += ctr/k;
                ctr = 0;
            }
        }
        //at the end of the day, whatever i have in ctr, check for it
        totalBouquets += ctr/k;

        return (totalBouquets >= m);
    }
    public int minDays(int[] bloomDay, int m, int k) {
        //Brute Force-Linear
        //edge case - where the ans is not possible
        if((long)bloomDay.length < (long)m*(long)k)
            return -1;

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int ele : bloomDay){
            min = Math.min(min, ele);
            max = Math.max(max, ele);
        }

        for(int d = min;d<=max;d++){
            if(isPossible(bloomDay, d, m, k)){
                return d;
            }
        }
        return -1;
    }
}

//time compl - O((max-min+1) * n)
//space compl - O(1)

//Optimised solution
//using binary search - as the search space is the range between min & max

class Solution {
    //function to check if day d is possible to make m bouquets or not
    public boolean isPossible(int[] arr, int d, int m, int k){
        int ctr = 0, totalBouquets = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] <= d){
                //when flower is blooming
                ctr++;
            }else{
                //flower not blooming
                totalBouquets += ctr/k;
                ctr = 0;
            }
        }
        //at the end of the day, whatever i have in ctr, check for it
        totalBouquets += ctr/k;

        return (totalBouquets >= m);
    }
    public int minDays(int[] bloomDay, int m, int k) {
        //Brute Force-Linear
        //edge case - where the ans is not possible
        if((long)bloomDay.length < (long)m*(long)k)
            return -1;

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int ele : bloomDay){
            min = Math.min(min, ele);
            max = Math.max(max, ele);
        }

        while(min <= max){
            int midDay = min + (max-min)/2;
            if(isPossible(bloomDay, midDay, m, k)){
                //as we've to find min days, go to left
                max = midDay-1;
            }else{
                //if it is not possible for this day, so any days on to left also not possible
                //so got right
                min = midDay+1;
            }
        }
        return min;
    }
}

//time compl - O(log(max-min+1)*n)
//space compl - O(1)