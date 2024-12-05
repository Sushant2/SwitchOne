//program to find floor and ceil of an element
//floor(ele) = largest ele <= x
//ceil(ele) = smallest ele >= x

public static int[] getFloorAndCeil(int[] a, int n, int x) {
      // Write your code here.
      int floor = -1;
      int ceil = -1;
      int low = 0;
      int high = n-1;
      while(low <= high){
        int mid = low + (high-low)/2;
        if(a[mid] <= x){
          floor = a[mid];
          low = mid+1;
        }else{
          high = mid-1;
        }
      }

      low = 0;
      high = n-1;
      while(low <= high){
        int mid = low + (high-low)/2;
        if(a[mid] >= x){
          ceil = a[mid];
          high = mid-1;
        }else{
          low = mid+1;
        }
      }

      return new int[]{floor, ceil};

    }


//time compl - O(2logn)
//space compl - O(1)