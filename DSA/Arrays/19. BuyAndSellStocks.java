//program to find the maximum profit of buying & selling stock
//LC - 121

//Brute Force
class Solution {
    public int maxProfit(int[] prices) {
        //Brute Force
        int maxProfit = 0;
        int n = prices.length;
        for(int i = 0;i<n-1;i++){
            int buy = prices[i];
            for(int j = i+1;j<n;j++){
                if(prices[j] > buy){
                    maxProfit = Math.max(maxProfit, (prices[j] - buy));
                }
            }
        }
        return maxProfit;
    }
}

//Time Compl - O(n^2)
//Space Compl - O(1)

//Better
//Buy at first day, now if there is any day where prices is dec, buy that day
//sell when price is greater than bought price

class Solution {
    public int maxProfit(int[] prices) {
        //Better
        int maxProfit = 0;
        int n = prices.length;
        int buy = prices[0];
        for(int i = 1;i<n;i++){
            if(prices[i] < buy)
                buy = prices[i];
            if(prices[i] > buy)
                maxProfit = Math.max(maxProfit, (prices[i] - buy));
        }
        return maxProfit;
    }
}

//Time Compl - O(n)
//Space Compl - O(1)