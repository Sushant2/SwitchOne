//Brute Force
//thought process-
//sort krdo(on basis of start) jisse closer intervals eksath ajayenge
//then pick first interval & check it with rest intervals if they are merging or not
//repeat it...

class Solution {
    public int[][] merge(int[][] arr) {
        int n = arr.length;
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0;i<n;i++){
            int start = arr[i][0];
            int end = arr[i][1];

            //to check that current interval is part of the previous interval
            if(!list.isEmpty() && list.get(list.size()-1).get(1) >= end)
                continue;
            for(int j = i+1;j<n;j++){
                if(arr[j][0] <= end){
                    end = Math.max(end, arr[j][1]);
                }
                else
                    break;
            }
            list.add(Arrays.asList(start, end));
        }
        int[][] ans = new int[list.size()][2];
        for(int i = 0;i<list.size();i++){
            for(int j = 0;j<2;j++){
                ans[i][j] = list.get(i).get(j);
            }
        }
        return ans;
    }
}

//time compl - O(nlogn) + O(2n - as every element got touched twice as we've used break & continue)
//space compl- O(n)

//Optimised

//we'll try to do it in single iteration
//checking the current interval if it lies in previous, merge
// otherwise add it as new

class Solution {
    public int[][] merge(int[][] arr) {
        int n = arr.length;
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> list = new ArrayList<>();

        for(int[] x : arr){
            if(list.isEmpty() || x[0] > list.get(list.size()-1)[1])
                list.add(x);
            else{
                list.get(list.size()-1)[1] = Math.max(x[1], list.get(list.size()-1)[1]);
            }
        }
        
        return list.toArray(new int[list.size()][]);
    }
}

//time compl - O(nlogn) + O(n)
//space compl - O(n)