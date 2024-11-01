//it is same as subarray sumequals k - problem 27
//using hashingg as prefix sum
public class Solution {
    public int solve(ArrayList<Integer> arr, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, 1);
        int preXor = 0;
        int cntXor = 0;
        for(int i = 0;i<arr.size();i++){
            preXor ^= arr.get(i);
            int x = preXor^k;
            if(map.containsKey(x)){
                int cnt = map.get(x);
                cntXor += cnt;
            }
            int val = map.getOrDefault(preXor, 0);
            map.put(preXor, val+1);
            
        }
        return cntXor;
    }
}


//time compl - O(n)
//space compl - O(n)