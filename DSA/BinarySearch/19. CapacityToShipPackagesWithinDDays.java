//Write a program to find capacity of ship to load all packages in D days as in given order

//Linear Search
class Solution {

    public boolean weightPossible(int wt, int[] weights, int days){
        int currDays = 0;
        for(int i = 0;i<weights.length;i++){
            int sum = 0;
            while(i < weights.length && sum + weights[i] <= wt){
                sum += weights[i];
                i++;
            }
            i--;
            currDays++;
            if(currDays > days) return false;
        }
        return true;
    }

    public int shipWithinDays(int[] weights, int days) {
        //Linear Search
        int low = Integer.MAX_VALUE, high = 0;
        for(int e : weights){
            high += e;
            low = Math.min(low, e);
        }

        while(low <= high){
            int wt = low + (high-low)/2;
            if(weightPossible(wt, weights, days)){
                //goto left
                high = wt-1;
            }else{
                low = wt+1;
            }
        }
        return low;
    }
}

//time compl - O((arrSum - maxArr) * n)
//space compl - O(1)

//Binary Search
class Solution {

    public boolean weightPossible(int wt, int[] weights, int days){
        int currDays = 0;
        for(int i = 0;i<weights.length;i++){
            int sum = 0;
            while(i < weights.length && sum + weights[i] <= wt){
                sum += weights[i];
                i++;
            }
            i--;
            currDays++;
            if(currDays > days) return false;
        }
        return true;
    }

    public int shipWithinDays(int[] weights, int days) {
        //Linear Search
        int low = Integer.MAX_VALUE, high = 0;
        for(int e : weights){
            high += e;
            low = Math.min(low, e);
        }

        while(low <= high){
            int wt = low + (high-low)/2;
            if(weightPossible(wt, weights, days)){
                //goto left
                high = wt-1;
            }else{
                low = wt+1;
            }
        }
        return low;
    }
}
//time compl - O(logn(arrSum - maxArr) * n)
//space compl - O(1)