//Program to intersection of 2 sorted arrays

//Brute force
//take a visited array to maintain if that element has been picked previously or not
public int[] intersection(int[] nums1, int[] nums2) {
    
    int n = nums1.length;
    int m = nums2.length;
    int[] vis = new int[m];
    ArrayList<Integer> inter = new ArrayList<>();
    for(int i = 0;i<n;i++){
        for(int j = 0;j<m;j++){
            if(nums1[i] == nums2[j] && vis[j] != 1){
                inter.add(nums1[i]);
                vis[j] = 1;
                break;
            }
            //no need of checking further as array is sorted
            if(nums2[j] > nums1[i])
                break;
        }
    }
    return inter;
}

//Time Compl - O(n^2)
//Space Compl - O(n)

//Optimised - inc both ptrs if both matched
//inc min pointer if they dont match

public int[] intersection(int[] nums1, int[] nums2) {
    int n = nums1.length;
    int m = nums2.length;
    ArrayList<Integer> inter = new ArrayList<>();
    while(i<n && j<m){
        if(nums1[i] < nums2[j])
            i++;
        else if(nums1[i] > nums2[j])
            j++;
        else if(nums1[i] == nums2[j]){
            inter.add(nums1[i]);
            i++;
            j++;
        }
    }
    return inter;
}