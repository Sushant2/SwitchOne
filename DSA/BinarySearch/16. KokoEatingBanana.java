//program to return minimum integer k such that koko can eat all bananas within h hours

//Linear search solution

class Solution {
    public int func(int k, int[] piles){
        int currEatTime = 0;
        for(int i = 0;i<piles.length;i++){
            //used double here as for eg piles[i] = 5, k = 2
            //if doing without double then - Math.ceil(5/2) = 2, as integer division drops the decimal part, so need to have in double
            currEatTime += Math.ceil((double)piles[i]/(double)k);
        }
        return currEatTime;
    }
    public int minEatingSpeed(int[] piles, int h) {
        //linear search
        int n = piles.length;
        int maxBanana = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++)
            maxBanana = Math.max(maxBanana, piles[i]);
        
        for(int k = 1;k<=maxBanana;k++){
            int currBananaPerHour = func(k, piles);
            if(currBananaPerHour <= h)
                return k;
        }
        return maxBanana;
    }
}

//time compl - O(maxBanana*n)

//Using Binary Search

class Solution {
    public int func(int k, int[] piles){
        int currEatTime = 0;
        for(int i = 0;i<piles.length;i++){
            currEatTime += Math.ceil((double)piles[i]/(double)k);
        }
        return currEatTime;
    }
    public int minEatingSpeed(int[] piles, int h) {
        //linear search
        int n = piles.length;
        int maxBanana = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++)
            maxBanana = Math.max(maxBanana, piles[i]);
        
        int low = 1, high = maxBanana;
        while(low <= high){
            int mid = low + (high-low)/2;
            
            int currBananaPerHour = func(mid, piles);
            if(currBananaPerHour <= h){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}

//return low here as after obersing in binary search - that the opposite polarity will have my ans at the end
//as if low start with no possiblity of answer, in the end, it'll have my answer
//as if high starts with no poosiblity of answer, in the end, it'll have my answer

//time compl - O(logMaxBanana*n)