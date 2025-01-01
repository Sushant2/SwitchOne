//Program to find unique triplets i, j, k such that arr[i] + arr[j] + arr[k] = 0 and i!=j, j!=k, i!=k

//Brute Force
//Generate all triplets
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> triplets = new HashSet<>();
        int len = nums.length;
        for(int i = 0;i<=len-3;i++){
            for(int j = i+1;j<=len-2;j++){
                for(int k = j+1;k<=len-1;k++){
                    if(nums[i] + nums[j] nums[k] == 0){
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(list);
                        triplets.add(list);
                    }
                }
            }
        }
        return new ArrayList<>(triplets);
    }
}

//Time Compl - O(n^3)
//Space Compl - O(2*n)//first to add into list & later in set

//Better
//if we try to do it in O(n^2) - we weould get rid of third loop
//so if we can find the third ele somehow
//we know a[i] + a[j] + a[k] = 0
//a[k] = -(a[i] + a[j])
//so we'll loop up for k & we do that using hasing
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> triplets = new HashSet<>();
        int len = nums.length;
        for(int i = 0;i<=len-3;i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j = i+1;j<=len-1;j++){
                int ele = -1 * (nums[i] + nums[j]);
                if(set.contains(ele)){
                    List<Integer> list = Arrays.asList(nums[i], nums[j], ele);
                    Collections.sort(list);
                    triplets.add(list);
                }
                set.add(nums[j]);
            }
        }
        return new ArrayList<>(triplets);
    }
}

//Time Compl - O(n^2.logn)
//Space Compl - O(n) + O(2*n) //in map & to add into list & later in set

//Optimal
//approach - in brute & better we were using set DS to store unique triplets, so we tried to do reverse
//first sorting the array & find sum a[i] + a[j] + a[k] = 0
//Using 2 pointers
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();
        int len = nums.length;
        for(int i = 0;i<=len-3;i++){
            int j = i+1;
            int k = len-1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    triplets.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while(j<k && nums[j] == nums[j-1])
                        j++;
                    while(j<k && nums[k] == nums[k+1])
                        k--;
                }
                else if(sum < 0){
                    j++;
                    while(j<k && nums[j] == nums[j-1])
                        j++;
                }
                else if(sum > 0){
                    k--;
                    while(j<k && nums[k] == nums[k+1])
                        k--;
                }
            }
            while(i <= len-3 && nums[i+1] == nums[i])
                i++;
        }
        return new ArrayList<>(triplets);
    }
}

//time compl - O(nlogn) + O(n^2)
//O(nlogn) for sorting the array and O(n^2)iterating the array elements using 3 pointes

//space compl - O(1) auxiliary space