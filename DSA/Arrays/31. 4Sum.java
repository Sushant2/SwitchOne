//Program to write 4 sum problem
//a!=b!=c!=d
//nums[a] + nums[b] + nums[c] + nums[d] == target

//Brute Force
//Generating all unique quads
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> ans = new HashSet<>();
        int n = nums.length;
        for(int i = 0;i<=n-4;i++){
            for(int j = i+1;j<=n-3;j++){
                for(int k = j+1;k<=n-2;k++){
                    for(int l = k+1;l<=n-1;l++){
                        if(nums[i] + nums[j] + nums[k] + nums[l] == target){
                            ArrayList<Integer> list = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                            Collections.sort(list);
                            ans.add(list);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(ans);
    }
}

//time compl - O(n^4)
//space compl - O(n)

//Better
//using hashset/hasmap
//we'll try to reduce time compl from O(n^4) to O(n^3)
//we know, nums[a] + nums[b] + nums[c] + nums[d] == target
//nums[a] = target - (nums[a] + nums[b] + nums[c])
//we'll look for nums[a] in set

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Set<List<Integer>> ans = new HashSet<>();
        
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                Set<Long> set= new HashSet<>();
                for(int k = j+1;k<n;k++){
                    long sum = nums[i] + nums[j];
                    sum += nums[k];
                    long rem = target - sum;
                    if(set.contains(rem)){
                        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], (int)rem));
                        Collections.sort(list);
                        ans.add(list);
                    }
                    set.add((long)nums[k]);
                }
            }
        }
        return new ArrayList<>(ans);
    }
}
//time compl - O(n^3)
//space compl - O(n)


//Optimised
//2 pointers
//remember to handle duplicates for i & j
///remember to handle long case
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0;i<=n-4;i++){
            if(i!=0 && nums[i] == nums[i-1])
                continue;
            for(int j = i+1;j<=n-3;j++){
                if(j!=i+1 && nums[j] == nums[j-1])
                    continue;
                int k = j+1;
                int l = n-1;
                while(k < l){
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if(sum < target){
                        k++;
                        while(k < l && nums[k] == nums[k-1]) k++;
                    }
                    else if(sum > target){
                        l--;
                        while(k < l && nums[l] == nums[l+1]) l--;
                    }
                    else{
                        ans.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k],nums[l])));
                        k++;
                        l--;
                        while(k < l && nums[k] == nums[k-1]) k++;
                        while(k < l && nums[l] == nums[l+1]) l--;
                    }
                }
            }
        }
        return ans;
    }
}

//time compl - O(n^3) + O(nlogn)
//space compl - O(1)
