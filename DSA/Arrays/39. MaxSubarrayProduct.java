// write a program to find the maximum subarray product

//brute force
//do it for every subarray
//return maxProd

class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProd = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            int currProd = 1;
            for(int j = i;j<n;j++){
                currProd *= nums[j];
                maxProd = Math.max(maxProd, currProd);
            }
        }
        return maxProd;
    }
}

//time compl - O(n^2)
//space compl - O(1)

//optimal 1
//using observation
//1. if all +ve no - then multiply all
//2. if even no of -ve, then multiply all
//3. if odd no of -ve, then find that 1 -ve number that we can remove to get the even no of -ve and find product of them
//[1, 4, 6 -2, 8, 5, 6, -1, 5, 3, 1, -3, 5]
//if we choose -2 as that -ve no - then we've 2 cases max((product of 1, 4, 6), (product of  8, 5, 6, -1, 5, 3, 1, -3, 5))
//if we choose -1 as that -ve no - then we've 2 cases max((product of 1, 4, 6 -2, 8, 5, 6, ), (product of  5, 3, 1, -3, 5))
//if we choose -3 as that -ve no - then we've 2 cases max((product of 1, 4, 6 -2, 8, 5, 6, -1, 5, 3, 1), (product of  5))

//so we see either our answer lie in prefix or suffix

//4. if there are 0s, we can skip 0s as prod of 0 always result in 0
//we can do same as in -ve for 0s

class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProd = Integer.MIN_VALUE;
        int prefixProd = 1;
        int suffixProd = 1;
        for(int i = 0;i<n;i++){
            if(prefixProd == 0) prefixProd = 1;
            if(suffixProd == 0) suffixProd = 1;
            prefixProd *= nums[i];
            suffixProd *= nums[n-i-1];
            maxProd = Math.max(maxProd, Math.max(prefixProd, suffixProd));
        }
        return maxProd;
    }
}

//time compl - O(n)
//space compl - O(1)
