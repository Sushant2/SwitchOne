//program to find median of 2 sorted arrays
//if even length then median will be - average of 2 middle ele
//if odd length then median will be - middle ele

//brute force
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //Brute force
        int m = nums1.length;
        int n = nums2.length;
        int len = m+n;
        int[] nums = new int[len];
        int i = 0, j = 0, k = 0;
        while(i < m && j < n){
            if(nums1[i] <= nums2[j])
                nums[k++] = nums1[i++];
            else
                nums[k++] = nums2[j++];
        }
        while(i < m){
            nums[k++] = nums1[i++];
        }
        while(j < n){
            nums[k++] = nums2[j++];
        }
        double ans = 0.0;
        if(len%2 == 0){
            ans = (double)((nums[len/2] + nums[(len/2)-1])/2.0);
        }else{
            ans = (double)(nums[len/2]);
        }
        return ans;
    }
}

//time compl - O(m+n)
//space compl - O(m+n)

//better approach
//using observation
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //Brute force
        int m = nums1.length;
        int n = nums2.length;
        int len = m+n;
        int i = 0, j = 0, ctr = 0;
        int sIdx = len/2;
        int fIdx = sIdx-1;
        int fEle = -1, sEle = -1;
        while(i < m && j < n){
            if(nums1[i] <= nums2[j]){
                if(ctr == fIdx)
                    fEle = nums1[i];
                if(ctr == sIdx)
                    sEle = nums1[i];
                ctr++;
                i++;
            }else{
                if(ctr == fIdx)
                    fEle = nums2[j];
                if(ctr == sIdx)
                    sEle = nums2[j];
                ctr++;
                j++;
            }
        }
        while(i < m){
            if(ctr == fIdx)
                fEle = nums1[i];
            if(ctr == sIdx)
                sEle = nums1[i];
            ctr++;
            i++;
        }
        while(j < n){
            if(ctr == fIdx)
                fEle = nums2[j];
            if(ctr == sIdx)
                sEle = nums2[j];
            ctr++;
            j++;
        }
        if(len%2 != 0)
            return sEle;
        
        return (double)((fEle + sEle)/2.0);
    }
}

//time compl - O(m+n)
//space compl - O(1)


//using binary search
//observe a symmatry from median
//how many element to take from arr1 and arr2 to make the correct left half of symmetry
//range from 0 to min(arr1.length, arr2.length)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       int m = nums1.length;
       int n = nums2.length;
       //if first array is bigger
       if(m > n) return findMedianSortedArrays(nums2, nums1); 
       int len = m+n;
       int left = (len+1)/2;
       int low = 0, high = m;
       while(low <= high){
        int mid1 = (low + high) >> 1; //how many from first array
        int mid2 = left - mid1; //how many from 2nd
        //values of l1, l2, r1, r2
        //on left side, if we pick 0 ele from arr1, so the l1 should be intmin
        //on left side, if we pick 0 ele from arr2, so the l2 should be intmin
        //on right side, if we pick 0 ele from arr1, so r1 should be intmax
        //on right side, if we pick 0 ele from arr2, so r2 should be intmax
        int l1 = (mid1 > 0) ? nums1[mid1 - 1] : Integer.MIN_VALUE;
        int l2 = (mid2 > 0) ? nums2[mid2 - 1] : Integer.MIN_VALUE;
        int r1 = (mid1 < m) ? nums1[mid1] : Integer.MAX_VALUE;
        int r2 = (mid2 < n) ? nums2[mid2] : Integer.MAX_VALUE;
        //valid case
        if(l1 <= r2 && l2 <= r1){
            //for odd
            if(len % 2 != 0)
                return Math.max(l1, l2);
            return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
        }else if(l1 > r2)
            high = mid1-1;
        else
            low = mid1+1;
       }

       return 0.0;
    }
}

//time compl - O(log(m+n)
//space compl - O(1)