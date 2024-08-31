//Program to write union of 2 sorted arrays & return the array in sorted order


//Brute Force
//Using TreeSet - to maintain insertion order and duplicacy

public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
{
    // add your code here
    
    Set<Integer> unionSet = new TreeSet<>();
    
    for(int i = 0;i<n;i++){
        unionSet.add(arr1[i]);
    }
    for(int i = 0;i<m;i++){
        unionSet.add(arr2[i]);
    }
    
    return new ArrayList<Integer>(unionSet);
}
//Time Compl - O(nlogn + mlogm)
//Space Compl - O(n + m)


//Optimised -using 2 pointers
//choose min from both -> if min, check if min already in union array > inc min pointer in both case whether already present in union or in case of insertion

public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
{
    // add your code here
    int i = 0;
    int j = 0;
    
    ArrayList<Integer> union = new ArrayList<>();
    while(i < n && j < m){
        if(arr1[i] <= arr2[j]){
            if(union.size() == 0 || union.get(union.size()-1) != arr1[i])
                union.add(arr1[i]);
            i++;
        }
        else{
            if(union.size() == 0 || union.get(union.size()-1) != arr2[j])
                union.add(arr2[j]);
            j++;
        }
    }
    
    while(i<n){
        if(union.size() == 0 || union.get(union.size()-1) != arr1[i])
            union.add(arr1[i]);
        i++;
    }
    
    while(j<m){
        if(union.size() == 0 || union.get(union.size()-1) != arr2[j])
            union.add(arr2[j]);
        j++;
    }
    
    
    return union;
}

//Time Compl - O(n + m)
//Space Compl - O(1) excluding arraylist used for returning answer