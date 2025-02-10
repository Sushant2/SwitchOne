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

