//Program to return first n pascal's trianle rows


//Brute Force
class Solution {
    public List<List<Integer>> generate(int numRows) {
        if(numRows <= 0)
            return new ArrayList<>();
        //Brute Force
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0;i<numRows;i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0;j<=i;j++){
                if(j==0 || j==i)
                    list.add(1);
                else {
                    int prevSum = ans.get(i-1).get(j-1) + ans.get(i-1).get(j);
                    list.add(prevSum);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}

//Time Compl - O(n^2)
//Space Compl - O(n^2) - to return answer