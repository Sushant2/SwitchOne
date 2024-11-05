//write a program to find 1 missing no & 1 repeating no, from the given array of size n, if elements are from 1 to n

//Naive/Brute Force

class Solution {
    // Function to find two elements in array
    ArrayList<Integer> findTwoElement(int arr[]) {
        int n = arr.length;
        int miss = 0, rep = 0;
        for(int i = 1;i<=n;i++){
            int cnt = 0;
            for(int j = 0;j<n;j++){
                if(arr[j] == i)
                    cnt++;
            }
            if(cnt == 2) rep = i;
            if(cnt == 0) miss == i;
        }
        return new ArrayList<>(Arrays.asList(rep, miss));
    }
}

//time compl - O(n^2)
//space compl - O(1)

//better approach using extra space
//visited array or hashmap

class Solution {
    // Function to find two elements in array
    ArrayList<Integer> findTwoElement(int arr[]) {
        int n = arr.length;
        int miss = 0, rep = 0;
        int[] vis = new int[n+1];
        for(int i = 1;i<=n;i++)
            vis[arr[i]]++;
        
        for(int i = 1;i<=n;i++){
            if(vis[i]==2) rep = i;
            if(vis[i]==0) miss = i;
            if(miss !=0 & rep !=0) break;
        }
        return new ArrayList<>(Arrays.asList(rep, miss));
    }
}


//time compl - O(n)
//space compl - O(n)

//OPTIMAL 1
//using maths
//we'll suppose x as repepting no & y as missing no
//we'll try to form 2 equations
//1. sum of first n natural no
//2. sum of sqaures of first n natural no
class Solution {
    // Function to find two elements in array
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        long n = arr.length;
        long s = 0, s2 = 0;
        long sn = (n*(n+1))/2;
        long s2n = (n*(n+1)*(2*n+1))/6;
        
        for(int x : arr){
            s += x;
            s2 += ((long)x*(long)x);
        }
        
        long eq1 = s-sn; //eq1 = x-y
        long eq2 = s2-s2n; //eq2 = x^2-y^2
        
        //eq2 = (x+y)(x-y)
        //eq2 = eq2/eq1 //so eq2 would be x+y
        
        eq2 = eq2/eq1;
        
        //x-y = eq1
        //x+y = eq2
    //   +
        //2x  = eq1+eq2
        //x   = eq1+eq2/2
        
        int rep = (int)(eq1 + eq2) /2;
        
        //we know x-y = eq1
        int miss = rep - (int)eq1;
        
        ArrayList<Integer> res = new ArrayList<>();
        res.add(rep);
        res.add(miss);
        return res;
    }
}

//time compl- O(n)
//space compl - O(1)

