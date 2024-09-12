//Program to find leaders in array
//considered a leader if it is greater than all the elements on its right side
//or if it is equal to the maximum element on its right side. 
//The rightmost element is always a leader.

//Brute Force
//for each element, check if its bigger than all elements on its right
//or equal to max on right

//Time Compl - O(n^2)
//Space Compl - O(n) - to return ans

//optimal
//start from right side
// & check for arr[i], is arr[i] > arr[i+1]
//also check there is no bigger than that on right in leaders array
class Solution {
    // Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int n, int arr[]) {
        // Your code here
        ArrayList<Integer> leaders = new ArrayList<>();
        leaders.add(arr[n-1]);
        for(int i = n-2;i>=0;i--){
            if(arr[i] >= arr[i+1] && arr[i] >= leaders.get(leaders.size()-1))
                leaders.add(arr[i]);
        }
        Collections.reverse(leaders);
        return leaders;
    }
}

//Time Compl - O(n)
//Space Compl - O(n) - to return ans