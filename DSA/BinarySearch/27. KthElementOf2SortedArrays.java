//problem to find kth element of 2 sorted arrays after merging

//Naive approach/Brute Force
//merge 2 sorted arrays & return kth element
class Solution {
    public int kthElement(int a[], int b[], int k) {
        // code here
        int m = a.length;
        int n = b.length;
        int[] c = new int[m+n];
        
        int i = 0, j = 0, idx = 0;
        while(i < m && j < n){
            if(a[i] <= b[j]){
                c[idx++] = a[i++];
            }else{
                c[idx++] = b[j++];
            }
        }
        while(i<m){
            c[idx++] = a[i++];
        }
        while(j<n){
            c[idx++] = b[j++];
        }
        
        return c[k-1];
    }
}

//time compl - O(m+n)
//space compl - O(m+n)

// Better Approach - Avoid using extra space
class Solution {
    public int kthElement(int a[], int b[], int k) {
        // code here
        int m = a.length;
        int n = b.length;
        int currEle = -1, currIdx = 0;
        
        int i = 0, j = 0;
        while(i < m && j < n){
            if(a[i] <= b[j]){
                currEle = a[i++];
                currIdx++;
            }else{
                currEle = b[j++];
                currIdx++;
            }
            if(currIdx == k)
                return currEle;
        }
        while(i<m){
            currEle = a[i++];
            currIdx++;
            if(currIdx == k)
                return currEle;
        }
        while(j<n){
            currEle = b[j++];
            currIdx++;
            if(currIdx == k)
                return currEle;
        }
        
        return -1;
    }
}

//time compl - O(m+n)
//space compl - O(1)

//optimised approach
//using binary search - same as median of 2 sorted arrays

class Solution {
    public int kthElement(int a[], int b[], int k) {
        // code here
        int m = a.length;
        int n = b.length;
        if(m > n)
            return kthElement(b, a, k);
        
        int low = Math.max(0, k-n), high = Math.min(k, m);
        while(low <= high){
            int cut1 = low + (high-low)/2;
            int cut2 = k - cut1;
            
            int l1 = cut1 == 0 ? Integer.MIN_VALUE : a[cut1-1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : b[cut2-1];
            int r1 = cut1 == m ? Integer.MAX_VALUE : a[cut1];
            int r2 = cut2 == n ? Integer.MAX_VALUE : b[cut2];
            
            if(l1 <= r2 && l2 <= r1){
                return Math.max(l1, l2);
            }else if(l1 > r2){
                high = cut1-1;
            }else{
                low = cut1+1;
            }
        }
        
        return -1;
    }
}

//time compl - O(log(min(m,n)))
//space compl - O(1)