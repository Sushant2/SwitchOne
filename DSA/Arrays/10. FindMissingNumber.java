//program to find missing number in array

//Brute Force - Using extra array/hash array

//take the hasharray with size+1
//mark the hasharray if that ele is present in arr
//iterate hasarray - if any equlals -1, then its missing number
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int[] temp = new int[n+1];
        for(int i = 0;i<=n;i++)
            temp[i] = -1;
        for(int i = 0;i<n;i++){
            temp[nums[i]] = 1;
        }

        for(int i = 0;i<=n;i++){
            if(temp[i] == -1)
                ans = i==0?0:i;
        }
        return ans;
    }
}

//Time Compl - O(n)
//Space Compl - O(n)

//Better - Sort the array
//if(arr[0]!=0) return 0
//if(arr[n-1]!=n) return n;
//iterate & if(arr[i]!=i) return i

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        if(nums[0]!=0)
            return 0;
        if(nums[n-1]!=n)
            return n;
        for(int i = 0;i<=n;i++)
            if(nums[i] != i)
                return i;

        return 0;
    }
}

//Time Compl - O(nlogn)
//Space Compl - O(1)

//Optimal 1 - Using Sum Of 1st n Natural Number
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sumOfN = n * (n+1)/2;
        int sum = 0;
        for(int i = 0;i<n;i++){
            sum += nums[i];
        }
        return sumOfN - sum;
    }
}

//Time Compl - O(n)
//Space Compl - O(1)

//But if n = 10^5 then sumOfN leads to 10^10 in that case need to change the datatype so use XOR

//Optimal 2 - Using XOR
//a^a = 0
//a^0 = a
//0^a = a

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xorOfN = 0;
        int xor = 0;
        for(int i = 0;i<n;i++){
            xor = xor ^ nums[i];
            xorOfN = xorOfN ^ (i+1);
        }
        return xorOfN ^ xor;
    }
}

//Time Compl - O(n)
//Space Compl - O(1)